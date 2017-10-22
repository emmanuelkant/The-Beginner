package practicing026;

/**
 * Classe do tipo funcion�rio, representado por {@code Employee}.
 * 
 * @author Emmanuel Kant
 *
 */
public class Employee {

	/** Atributo que armazenar� o nome do funcion�rio */
	private String name;

	/**
	 * Construtor de Employee.
	 * 
	 * @param name
	 *            Nome recebido do usu�rio.
	 */
	public Employee(String name) {
		this.name = name;
	}

	/**
	 * Recupera o valor do atributo name.
	 * 
	 * @return Valor de name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Atribui valor ao atributo name.
	 * 
	 * @param name
	 *            Nome recebido do usu�rio.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * M�todo que ser� herdado para todas as classes filhas. Ele ser� e dever�
	 * se sobrescrito.
	 * 
	 * @return Valor default de um float.
	 */
	public float getSalary() {
		return 0.0f;
	}

}
