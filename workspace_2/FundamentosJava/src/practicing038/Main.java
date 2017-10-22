package practicing038;

/**
 * Classe principal do sistema.
 * 
 * @author Emmanuel Kant
 *
 */
public class Main {

	/**
	 * Método que dispara a aplicação.
	 * 
	 * @param args
	 *            Não espero nada como parâmetros.
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
