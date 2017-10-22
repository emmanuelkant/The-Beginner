package practicing038;

/**
 * Classe principal do sistema.
 * 
 * @author Emmanuel Kant
 *
 */
public class Main {

	/**
	 * M�todo que dispara a aplica��o.
	 * 
	 * @param args
	 *            N�o espero nada como par�metros.
	 */
	public static void main(String[] args) {

		Country country1 = new Country(Planet.MARTE, "Chucala");
		Country country2 = new Country(Planet.JUPITER, "Adamap");
		Country country3 = new Country(Planet.VENUS, "Trilinox");

		System.out.println(country1.toString());
		System.out.println(country2.toString());
		System.out.println(country3.toString());

	}

}
