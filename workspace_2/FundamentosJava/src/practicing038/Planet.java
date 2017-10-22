package practicing038;

/**
 * Enum que configura o planeta que ele é.
 * 
 * @author Emmanuel Kant
 *
 */
public enum Planet {

	MARTE(254546.54f, 16.5f), VENUS(458786.98f, 4.7f), JUPITER(6854716.4f, 2.1f);

	/** Raio do planeta em Kilometros. */
	private final float radius;
	/** A gravidade do planeta. */
	private final float gravity;

	/**
	 * Construtor do enum {@code Planet}.
	 * 
	 * @param radius
	 *            Raio do planeta.
	 * @param gravity
	 *            Gravidade do planeta.
	 */
	private Planet(float radius, float gravity) {
		this.radius = radius;
		this.gravity = gravity;
	}

	/**
	 * @return O raio do planeta em Kilometros.
	 */
	public float getRadius() {
		return radius;
	}

	/**
	 * @return A gravidade do planeta.
	 */
	public float getGravity() {
		return gravity;
	}

	@Override
	/**
	 * Sobrescrita do método {@code toString()}. Retorna o que esse objeto
	 * contém.
	 */
	public String toString() {
		return "Gravidade: " + getGravity() + ";\n" + "Raio: " + getRadius();
	}

}
