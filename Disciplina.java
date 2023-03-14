import java.util.ArrayList;

public class Disciplina{
    
    private String nome;
    private Pessoa professor;
    private ArrayList<Estudante> alunos = new ArrayList<Estudante>();


    public Disciplina(String nome, Pessoa professor){
        setNome(nome);
        setProfessor(professor);
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setProfessor(Pessoa professor){
        this.professor = professor;
    }

    public Pessoa getProfessor(){
        return professor;
    }

    public void adicionarAluno(Estudante estudante){
        alunos.add(estudante);
    }

    public void imprimirAlunos(){

        for (int i=0; i< alunos.size(); i++){
            System.out.println("Aluno " + (i+1));
            System.out.println(alunos.get(i));
            System.out.print("\n");
        }
    }

    public int getNumeroDeAlunos(){
        return alunos.size();
    }

    public String toString(){
        return "Nome da disciplina: " + getNome() + "\nProfessor: " + getProfessor().getNome() + "\nAlunos matriculados: " + getNumeroDeAlunos();
    } 
}