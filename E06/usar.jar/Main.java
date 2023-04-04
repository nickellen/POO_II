import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class programaTeste {

	public static void main(String[] args) {
		
		Funcao2 func = new Funcao2(2.5,5.4,3.5);	
		Class<?> classe = func.getClass();
		imprimeMetodos(classe);
		imprimeConstrutores(classe);	
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
}
