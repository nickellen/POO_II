import java.util.Calendar;

public class Pessoa{

    private String nome;
    private Calendar dataDeNascimento;
    private char sexo;

    public Pessoa(String nome, int dia, int mes, int ano, char sexo){
        setNome(nome);
        setSexo(sexo);
        setDataDeNascimento(dia, mes, ano);
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setDataDeNascimento(int dia, int mes, int ano){
        dataDeNascimento = Calendar.getInstance();
        dataDeNascimento.set(ano, mes, dia);
    }

    public void setSexo(char sexo){
        if ((sexo =='F') || (sexo =='M')){
            this.sexo = sexo;
        }
    }

    public String getSexo(){
        if (sexo =='M'){
            return "Masculino";
        }
        if (sexo == 'F'){
            return "Feminino";
        }
        return "-";
    }

    public int obterIdade(){
        Calendar dataAtual = Calendar.getInstance();

        int idade = dataAtual.get(Calendar.YEAR) - dataDeNascimento.get(Calendar.YEAR);

        if (dataAtual.get(Calendar.MONTH) < dataDeNascimento.get(Calendar.MONTH)){
            return idade-1;
        }
        return idade;
    }

    public String getDataDeNascimento(){
        return dataDeNascimento.get(Calendar.DAY_OF_MONTH) + "/" + dataDeNascimento.get(Calendar.MONTH) + "/" +dataDeNascimento.get(Calendar.YEAR);
    }

    public String toString(){
        return "Nome: "+ getNome() + "\nIdade: " + obterIdade() + "\nSexo: " + getSexo();
    }
}
