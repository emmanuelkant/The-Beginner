package practicing047;

public class SwitchsAndFors {

	void testSwitch() {

		String s = "Coisa";
		final String s1 = "Coisa";
		switch (s) {
		case "f":
			// code
			break;
		case "oisa":
			// code
			break;
		case s1: // Para estar dentro do switch a variavel deve ser constante.
			// code
			break;
		default:
			// code
			break;
		}

		int a = 3;
		switch (a) {
		case 1:
			// code
			break;
		case 2:
			// code
			break;
		case 3:
			// code
			break;
		default:
			// code
			break;
		}

	}

}
