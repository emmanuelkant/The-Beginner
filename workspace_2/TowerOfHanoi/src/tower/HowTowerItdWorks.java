package tower;

public class HowTowerItdWorks{

	/**
	 * Realiza o movimento
	 * 
	 * @param source
	 * @param destination
	 */
	private void move(int source, int destination) {
		System.out.println(source + " -> " + destination);
	}

	public void executeHanoi(int n, int source, int destination, int aux) {
		if (n > 0) { // Stop condicion.
			executeHanoi(n - 1, source, aux, destination);
			System.out.print("Movendo a peça " + n + " do pino ");
			move(source, destination);
			executeHanoi(n - 1, aux, destination, source);
		}
		// Árvore de Recursão.
	}

	
	public static void main(String[] args) {
		new HowTowerItdWorks().executeHanoi(3, 1, 3, 2);
	}

//	public void executeHanoiTest(int n, int source, int destination, int aux) {
//		if (n > 0) { // Stop condicion.
//			executeHanoiTest(n - 1, source, destination, aux);
//			move(source, destination);
//			executeHanoiTest(n - 1, source, destination, aux);
//		}
//		// Árvore de Recursão.
//	}
}