package practicing026;

/**
 * Classe do tipo funcionário, representado por {@code Employee}.
 * 
 * @author Emmanuel Kant
 *
 */
public class Employee {

	/** Atributo que armazenará o nome do funcionário */
	private String name;

	/**
	 * Construtor de Employee.
	 * 
	 * @param name
	 *            Nome recebido do usuário.
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
	 *            Nome recebido do usuário.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Método que será herdado para todas as classes filhas. Ele será e deverá
	 * se sobrescrito.
	 * 
	 * @return Valor default de um float.
	 */
	public float getSalary() {
		return 0.0f;
	}

}
