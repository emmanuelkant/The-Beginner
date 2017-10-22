package practicing026;

/**
 * Classe secretária, repersentada por {@code Secretary}. Ela extende de
 * {@code Employee}.
 * 
 * @author Emmanuel Kant
 *
 */
public class Secretary extends Employee {

	/** Valor que será somado ao atributo {@code baseSalary} */
	private float bonus;
	/** Valor do salário mensal da secretária */
	private float baseSalary;

	/**
	 * Construtor da classe secretária.
	 * 
	 * @param name
	 *            Nome da secretária.
	 * @param salary
	 *            Salário da secretária.
	 * @param bonus
	 *            Valor que será somado ao seu salário no fim do mês.
	 */
	public Secretary(String name, float salary, float bonus) {
		super(name);
		this.bonus = bonus;
		this.baseSalary = salary;
	}

	/**
	 * Retorna o valor armazenado em {@code bonus}.
	 * 
	 * @return Valor do atributo.
	 */
	public float getBonus() {
		return bonus;
	}

	/**
	 * Método que atribui um valor ao atributo {@code bonus}.
	 * 
	 * @param bonus
	 *            Valor que será acrescido no salário da secretária.
	 */
	public void setBonus(float bonus) {
		this.bonus = bonus;
	}

	/**
	 * Método que retorna o salário mais o bonus.
	 */
	@Override
	public float getSalary() {
		return this.baseSalary + bonus;
	}

	/**
	 * Método que atribui um valor ao atributo {@code salary}.
	 * 
	 * @param salary
	 *            Salário recebido do usuário.
	 */
	public void setSalary(float salary) {
		this.baseSalary = salary;
	}

	/**
	 * Método que retorna o valor do atual objeto
	 */
	@Override
	public String toString() {
		return "Nome: " + getName() + " - " + "Salário: " + getSalary() + "\n\n";
	}

}
