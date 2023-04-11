from modelo import *
from configuracoes import *

def add(obj):
    db.session.add(obj)
    db.session.commit()

def consultaTot(classe):
    print(f"\nOcorrências da classe {classe.__name__}: ")
    for i in classe.query.all():
        print(i)

def PessoaPorLetra(letra):
    print(f"\nPessoas que comecaçam com a letra {letra}: ")
    for i in db.session.query(Pessoa).all():
        if i.nome[0]== letra:
            print(i)

def PessoaPorNome(nome):
    print(f"\nPessoas com o nome {nome}: ")
    pessoas = Pessoa.query.filter(Pessoa.nome.like("Juliana"))
    for i in pessoas:
        print(i)

def consultaOp(operadora):
    print(f"\nChips da {operadora}: ")
    chips = CartaoSim.query.filter_by(operadora = operadora)
    for i in chips:
        print(i)

def excluirLinha(classe, id):
    db.session.query(classe).filter(classe.id==id).delete()
    db.session.commit()
