package practicing038;

/**
 * Classe que define pa�s.
 * 
 * @author Emmanuel Kant
 *
 */
public class Country {

	/** Planeta em que o pa�s est�. */
	private Planet planet;
	/** Nome do pa�s. */
	private String name;

	/**
	 * Contrutor da classe {@code Country}.
	 * 
	 * @param planet
	 *            Planeta em que est� o pa�s
	 * @param name
	 *            Nome do pa�s.
	 */
	public Country(Planet planet, String name) {
		super();
		this.planet = planet;
		this.name = name;
	}

	/**
	 * @return the planet
	 */
	public Planet getPlanet() {
		return planet;
	}

	/**
	 * @param planet
	 *            the planet to set
	 */
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sobrescrita do m�todo {@code toString()}. Returna o que esse objeto
	 * cont�m.
	 */
	public String toString() {
		return "Pa�s: " + getName() + ";\n" + "Planeta: " + getPlanet().name() + ";\n" + this.planet.toString() + ".\n";
	}

}
