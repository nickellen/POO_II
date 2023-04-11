from funcoes import *
from configuracoes import *
from modelo import *
from datetime import date

if __name__ == "__main__":

    if utilizar == "sqlite":
        if os.path.exists(arquivobd):
                os.remove(arquivobd)
    db.create_all()

    #--------------------------------Adicionando
    p1 = PessoaFisica(nome = "João da Silva", email = "josilva@gmail.com", cpf="11715643925", dataDeNascimento = date(2004,2,14))
    p2 = PessoaFisica(nome = "Maria Oliveira", email = "molive@gmail.com", cpf ="15478524555", dataDeNascimento = date(2010,5,25))        
    p3 = PessoaFisica(nome = "Juliana", email = "jualia@gmail.com", cpf="1875745925", dataDeNascimento = date(2010,2,1))
    p4 = PessoaFisica(nome = "Juliana", email = "juliana2@gmail.com", cpf ="22839415725", dataDeNascimento = date(1999,5,5))  
    p5 = Pessoa(nome = "Juliana", email = "juliana2@gmail.com")       
     
    add(p1), add(p2), add(p4), add(p3), add(p5)

    c1 = Celular(IMEI = "125",marca = "Iphone", dono = p1)
    c2 = Celular(IMEI = "122", marca = "Samsung", dono = p2)
    add(c1) , add(c2)

    cs1 = CartaoSim(ICCID = "154" , celular = c1, operadora = "Claro")
    cs2 = CartaoSim(ICCID = "155" , operadora = "Claro")
    add(cs1), add(cs2)

    #---------------------------------Consultas

    consultaTot(Celular)

    print("\nCartão sim sem ligação a um celular: ")
    cartao = CartaoSim.query.filter_by(celular = None).first()
    print(cartao)

    consultaOp("Claro")
    PessoaPorNome("Juliana")
    PessoaPorLetra('J')

    #-------------------------------Modificando
    
    celularUp = Celular.query.filter_by(IMEI = "122").first()
    print("\nCelular: ", celularUp)
    celularUp.dono = p3
    db.session.commit()
    print("Celular alterado: ", celularUp)

    #---------------------------------Excluindo

    excluirLinha(PessoaFisica, 4)
    excluirLinha(Celular, 2)
    consultaTot(PessoaFisica)
    consultaTot(Celular)