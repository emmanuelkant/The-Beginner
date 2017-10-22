package practicing026;

/**
 * Classe do tipo professor, representada por {@code Professor}. Ela extende de
 * {@code Employee}.
 * 
 * @author Emmanuel Kant
 *
 */
public class Professor extends Employee {

	/** Atributo para armazenar o valor de cada hora. */
	private float hoursValue;
	/**
	 * Atributo para armazenar o valor total das horas de aula dada pelo
	 * docente.
	 */
	private int hoursMonthly;
	
	protected int test;

	/**
	 * Construtor da classe Professor.
	 * 
	 * @param name
	 *            Nome recebido pelo usuário.
	 * @param hoursValue
	 *            Valor de cada hora recebido pelo usuário.
	 * @param hoursMonthly
	 *            Total das horas/aulas dadas em um mês.
	 */
	public Professor(String name, float hoursValue, int hoursMonthly) {
		super(name);
		this.hoursValue = hoursValue;
		this.hoursMonthly = hoursMonthly;
	}

	/**
	 * Método que retorna o total de horas de aulas ministradas pelo professor.
	 * 
	 * @return Total de horas em um mês.
	 */
	public int getHoursMonthly() {
		return hoursMonthly;
	}

	/**
	 * Método que atribui um valor a {@code hoursMonthly}.
	 * 
	 * @param hoursMonthly
	 *            Total de horas recebido do usuário.
	 */
	public void setHoursMonthly(int hoursMonthly) {
		this.hoursMonthly = hoursMonthly;
	}

	/**
	 * Método que atribui um valor a {@code hoursValue}.
	 * 
	 * @param hoursValue
	 *            Valor de cada hora dada pelo docente.
	 */
	public void setHoursValue(float hoursValue) {
		this.hoursValue = hoursValue;
	}

	/**
	 * Método que retorna o valor de {@code hoursValue}.
	 * 
	 * @return O valor de cada hora dada pelo usuário.
	 */
	public float getHoursValue() {
		return hoursValue;
	}

	/**
	 * Método que retorna o produto da multiplicação do valor de horas de aula
	 * vezes o valor de cada hora.
	 */
	@Override
	public float getSalary() {
		return this.hoursMonthly * this.hoursValue;
	}

	/**
	 * Método que retorna o valor do atual objeto
	 */
	@Override
	public String toString() {
		return "Nome: " + getName() + " - " + "Salário: " + getSalary() + "\n\n";
	}

}
