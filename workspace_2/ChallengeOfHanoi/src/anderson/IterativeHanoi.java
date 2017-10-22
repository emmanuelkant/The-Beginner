package anderson;

public class IterativeHanoi {
	/** Pilha que guardara os movimentos a serem feitos. */
	private LinkedStack stack = new LinkedStack();

	/** Metodo que estarta a aplicacao */
	public static void main(String[] args) {

	}

	/**
	 * Metodo que realiza o movimento.
	 * 
	 * @param source
	 * @param destination
	 */
	private void move(int source, int destination) {
		System.out.println(source + " -> " + destination);
	}

	public void executeHanoi(int n, int source, int destination, int aux) {

		Command currectCommand = new Command(n, source, destination, aux);

		stack.push(currectCommand);

		while (!stack.isEmpty()) {

			if (n > 1) {
				n--;
				currectCommand = new Command(n, source, aux, destination);
				stack.push(currectCommand);
			} else {

				currectCommand = (Command) stack.pop();
				
				move(currectCommand.getSource(), currectCommand.getDestination());

			}

		}

	}

}
