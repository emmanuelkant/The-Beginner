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
	 *            Nome recebido pelo usu�rio.
	 * @param hoursValue
	 *            Valor de cada hora recebido pelo usu�rio.
	 * @param hoursMonthly
	 *            Total das horas/aulas dadas em um m�s.
	 */
	public Professor(String name, float hoursValue, int hoursMonthly) {
		super(name);
		this.hoursValue = hoursValue;
		this.hoursMonthly = hoursMonthly;
	}

	/**
	 * M�todo que retorna o total de horas de aulas ministradas pelo professor.
	 * 
	 * @return Total de horas em um m�s.
	 */
	public int getHoursMonthly() {
		return hoursMonthly;
	}

	/**
	 * M�todo que atribui um valor a {@code hoursMonthly}.
	 * 
	 * @param hoursMonthly
	 *            Total de horas recebido do usu�rio.
	 */
	public void setHoursMonthly(int hoursMonthly) {
		this.hoursMonthly = hoursMonthly;
	}

	/**
	 * M�todo que atribui um valor a {@code hoursValue}.
	 * 
	 * @param hoursValue
	 *            Valor de cada hora dada pelo docente.
	 */
	public void setHoursValue(float hoursValue) {
		this.hoursValue = hoursValue;
	}

	/**
	 * M�todo que retorna o valor de {@code hoursValue}.
	 * 
	 * @return O valor de cada hora dada pelo usu�rio.
	 */
	public float getHoursValue() {
		return hoursValue;
	}

	/**
	 * M�todo que retorna o produto da multiplica��o do valor de horas de aula
	 * vezes o valor de cada hora.
	 */
	@Override
	public float getSalary() {
		return this.hoursMonthly * this.hoursValue;
	}

	/**
	 * M�todo que retorna o valor do atual objeto
	 */
	@Override
	public String toString() {
		return "Nome: " + getName() + " - " + "Sal�rio: " + getSalary() + "\n\n";
	}

}
