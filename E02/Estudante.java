public class Estudante extends Pessoa {

    public Estudante(String nome, int dia, int mes, int ano, char sexo, long matricula, int serie) {
        super(nome, dia, mes, ano, sexo);
        setMatricula(matricula);
        setSerie(serie);
    }

    private long matricula;
    private int serie;

    public void setMatricula(long matricula){
        if (matricula>0){
            this.matricula = matricula;
        }
    }

    public long getMatricula(){
        return matricula;
    }

    public void setSerie(int serie){
        this.serie = serie;
    }

    public int getSerie(){
        return serie;
    }
    
    public String toString(){
        return super.toString() + "\nMatricula: " + matricula;
    } 
}
