package practicing038;

/**
 * Classe que define país.
 * 
 * @author Emmanuel Kant
 *
 */
public class Country {

	/** Planeta em que o país está. */
	private Planet planet;
	/** Nome do país. */
	private String name;

	/**
	 * Contrutor da classe {@code Country}.
	 * 
	 * @param planet
	 *            Planeta em que está o país
	 * @param name
	 *            Nome do país.
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
	 * Sobrescrita do método {@code toString()}. Returna o que esse objeto
	 * contém.
	 */
	public String toString() {
		return "País: " + getName() + ";\n" + "Planeta: " + getPlanet().name() + ";\n" + this.planet.toString() + ".\n";
	}

}
