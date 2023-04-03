class Casa:

    def __init__(self, cor, qt_quartos, qt_banheiros):
        self.cor = cor
        self.qt_quartos = qt_quartos
        self.qt_banheiros = qt_banheiros
        
    def pintar(self, nova_cor):
        self.cor = nova_cor
        
    def adicionar_quarto(self):
        self.qt_quartos += 1
        
    def adicionar_banheiro(self):
        self.qt_banheiros += 1
    
    def __add__(self, other):
        return self.__str__() + other.__str__()

    def __str__(self):
        return f"Casa de cor {self.cor} com {self.qt_quartos} quartos e {self.qt_banheiros} banheiros."

class Banana:

    def __init__(self, estado):
        self.estado = estado
    
    def setEstado(self, estado):
        self.estado = estado

    def __add__(self, other):
        return self.__str__() + other.__str__()

    def __str__(self):
        return f"A banana está {self.estado}."

def quickSort(lista, fim = None, inicio=0):

    if (fim==None):
        fim = len(lista)-1

    if (inicio < fim):
        pivo = particiona(lista, fim, inicio)
        quickSort(lista, pivo-1, inicio)
        quickSort(lista, fim, pivo+1)
    
def particiona(lista, fim,  inicio): 

    pivo = lista[fim]
    i = inicio
    
    for j in range(inicio, fim):
        if lista[j] <= pivo:
            troca(lista, i, j)
            i+=1
    
    troca(lista , i, fim)
    return i

def troca(lista, a, b):
    tmp = lista[a]
    lista[a] = lista[b]
    lista[b] = tmp


def main():
    banana = Banana("Madura")
    casa = Casa("Verde", 5, 2)
    print(casa + banana + quickSort.__name__)

if __name__=="__main__":
    main()
