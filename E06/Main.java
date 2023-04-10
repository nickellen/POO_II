import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import br.com.headjava.CalculadoraSimples;

public class programaTeste {

	public static void main(String[] args) {
		
		CalculadoraSimples calc = new CalculadoraSimples(5,1);	
		Class<?> classe = calc.getClass();
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
