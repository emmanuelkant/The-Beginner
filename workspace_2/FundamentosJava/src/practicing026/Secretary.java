package practicing026;

/**
 * Classe secret�ria, repersentada por {@code Secretary}. Ela extende de
 * {@code Employee}.
 * 
 * @author Emmanuel Kant
 *
 */
public class Secretary extends Employee {

	/** Valor que ser� somado ao atributo {@code baseSalary} */
	private float bonus;
	/** Valor do sal�rio mensal da secret�ria */
	private float baseSalary;

	/**
	 * Construtor da classe secret�ria.
	 * 
	 * @param name
	 *            Nome da secret�ria.
	 * @param salary
	 *            Sal�rio da secret�ria.
	 * @param bonus
	 *            Valor que ser� somado ao seu sal�rio no fim do m�s.
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
	 * M�todo que atribui um valor ao atributo {@code bonus}.
	 * 
	 * @param bonus
	 *            Valor que ser� acrescido no sal�rio da secret�ria.
	 */
	public void setBonus(float bonus) {
		this.bonus = bonus;
	}

	/**
	 * M�todo que retorna o sal�rio mais o bonus.
	 */
	@Override
	public float getSalary() {
		return this.baseSalary + bonus;
	}

	/**
	 * M�todo que atribui um valor ao atributo {@code salary}.
	 * 
	 * @param salary
	 *            Sal�rio recebido do usu�rio.
	 */
	public void setSalary(float salary) {
		this.baseSalary = salary;
	}

	/**
	 * M�todo que retorna o valor do atual objeto
	 */
	@Override
	public String toString() {
		return "Nome: " + getName() + " - " + "Sal�rio: " + getSalary() + "\n\n";
	}

}
