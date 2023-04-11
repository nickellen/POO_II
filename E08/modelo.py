from configuracoes import *
from datetime import date

class Pessoa(db.Model):

    id = db.Column(db.Integer, primary_key=True)
    nome = db.Column(db.String(254))
    email = db.Column(db.String(254))
    type = db.Column(db.String(50))

    __mapper_args__ = {
        'polymorphic_identity':'pessoa', 
        'polymorphic_on':type
    }
    def __str__(self):
        return f'{self.nome}, {self.email}'

class PessoaFisica(Pessoa):
    
    __mapper_args__ = { 
        'polymorphic_identity':'pessoafisica',
    }

    cpf = db.Column(db.String(11))
    celulares = db.relationship("Celular", backref="dono")
    dataDeNascimento = db.Column(db.Date)


    def __str__(self):
        return super().__str__() + f", {self.cpf}, {self.dataDeNascimento.day}/{self.dataDeNascimento.month}/{self.dataDeNascimento.year}"
    
class Celular(db.Model):

    id = db.Column(db.Integer, primary_key=True)
    IMEI = db.Column(db.String(254))

    marca = db.Column(db.String(254))

    dono_id = db.Column(db.Integer, db.ForeignKey(PessoaFisica.id), 
                          nullable=False)

    def __str__(self):
        return f"IMEI: {self.IMEI}, {self.marca}, pertence à: {self.dono.nome}"

class CartaoSim(db.Model):

    id = db.Column(db.Integer, primary_key=True)
    ICCID = db.Column(db.String(254))
    celular_id = db.Column(db.Integer, db.ForeignKey(Celular.id), nullable= True)
    celular = db.relationship("Celular")
    operadora = db.Column(db.String(254))

    def __str__(self):
        if (self.celular!=None):
            return  f"ICCID: {self.ICCID}, {self.operadora}, Celular: {self.celular}"
        return  f"ICCID: {self.ICCID}, {self.operadora}"