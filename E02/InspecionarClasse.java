import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InspecionarClasse{

    public static void main(String[] args){

        Object[] args1 = {"Adelaide", 17,01,1978,'F'};
        Pessoa professor = (Pessoa) instanciarClasse(Pessoa.class,  args1);

        Object[] args2 = {"Paulo", 23,10,2015,'M', 20231487,2};
        Estudante estudante = (Estudante) instanciarClasse(Estudante.class,  args2);


        Object[] args3 = {"Artes", professor};
        Disciplina disciplina = (Disciplina) instanciarClasse(Disciplina.class,  args3);

        imprimeAtributos(Pessoa.class);
        imprimeMetodos(Estudante.class);
        imprimeConstrutores(Disciplina.class);
        imprimeHeranca(Estudante.class);

        Estudante[] arg = {estudante};
        executarMetodos(disciplina, Disciplina.class, "adicionarAluno", arg);

        System.out.println(disciplina + "\n");
        executarMetodos(disciplina, Disciplina.class, "imprimirAlunos");
    }

    // instanciar uma classe por meio de um construtor com parâmetros.
    public static Object instanciarClasse(Class<?> classe, Object[] lista){
        
        try {

            Constructor<?> constr = classe.getDeclaredConstructors()[0];

            Object obj = (Object) constr.newInstance(lista);
            return obj;

        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e) {
                e.printStackTrace();
                return "Erro ao instanciar objeto.";
        }
    }

    // instanciar uma classe por meio de um construtor sem parâmetros.
    public static Object instanciarClasse(Class<?> classe){

        try {

            Constructor<?> constr = classe.getDeclaredConstructors()[0];
            Object obj = (Object) constr.newInstance();
            return obj;

        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
                e.printStackTrace();
                return "Erro ao instanciar objeto.";
        }
    }

    public static void imprimeHeranca( Class<?> classe){

            Class<?> heranca = classe.getSuperclass();
            System.out.println("\n" + classe.getName() + " herda: " + heranca + "\n");
    }

    public static void imprimeAtributos(Class<?> classe){

        Field[] atributos = classe.getDeclaredFields();

        System.out.println("\nAtributos da classe " + classe.getName() + ":");

        int i = 1;
        for (Field atributo: atributos){
            System.out.println(i + " - " + atributo);
            i++;
        }
    }

    public static void imprimeMetodos(Class<?> classe){

        Method[] metodos = classe.getDeclaredMethods();

        System.out.println("\nMetodos da classe " + classe.getName() + ":");

        int i = 1;
        for  (Method metodo: metodos){
            System.out.println(i + " - " + metodo);
            i++;
        }
    }

    public static void imprimeConstrutores(Class<?> classe){

        Constructor<?>[] construtores = classe.getDeclaredConstructors();

        System.out.println("\nConstrutores da classe " + classe.getName() + ":");

        int i = 1;
        for  (Constructor<?> construtor: construtores){
            System.out.println(i + " - " + construtor);
            i++;
        }
    }

    // executa um método com parâmetros.
    public static void executarMetodos(Object obj, Class<?> classe, String nomeMetodo, Object[] listaArgs){

        try {
            Method[] metodos = classe.getMethods();

            Method m = encontrarMetodo(metodos, nomeMetodo);
            m.invoke(obj, listaArgs);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // executa um método sem parâmetros.
    public static void executarMetodos(Object obj, Class<?> classe, String nomeMetodo){
           
        try {
            
            Method[] metodos = classe.getMethods();
            Method m = encontrarMetodo(metodos, nomeMetodo);
            m.invoke(obj);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Preocura na classe o método e o retorna se encontrado.
    public static Method encontrarMetodo(Method[] metodos, String nomeMetodo) throws Exception {

        for (Method metodo: metodos){
            if (metodo.getName().equals(nomeMetodo)){
                return metodo;
            }
        }
        throw new Exception("Método não encontrado");
    }
}
