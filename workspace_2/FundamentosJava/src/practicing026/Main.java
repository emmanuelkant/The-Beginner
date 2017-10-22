package practicing026;

import java.util.ArrayList;

/**
 * Classe principal do sistema.
 * 
 * @author Emmanuel Kant
 *
 */
public class Main {

	/**
	 * Método principal do software.
	 * 
	 * @param args
	 *            Arumentos passados na linha de comando.
	 */
	public static void main(String[] args) {

		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		employees.add(new Professor("João", 50.00f, 44));
		employees.add(new Professor("Júlia", 55.00f, 40));
		employees.add(new Professor("Paulo", 45.00f, 50));
		employees.add(new Secretary("Roberta", 1000.00f, 400.00f));
		employees.add(new Secretary("Viviane", 1000.00f, 450.00f));

		for (Employee e : employees) {
			System.out.println(e);
		}

	}

}
