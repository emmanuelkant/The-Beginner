package practicing050;

public class ContinueAndBreak {

	void continueTesting() {
		/*
		 * O continue faz com que o fluxo laco seja interrompido e ele avance
		 * para a proxima iteracao.
		 */
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " Time before continue");
			if (i == 3 || i == 6) {
				System.out.println("Continue\n");
				continue;
			}
			System.out.println(i + " Time after continue\n");
		}
	}

	public static void main(String[] args) {
		new ContinueAndBreak().continueTesting();
	}

}
