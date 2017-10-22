package sort;

public class BubbleSort {

	/**
	 * Método que ordena um array de inteiros.
	 * 
	 * @param array
	 *            Matriz passado pelo usuário.
	 * @return Um array ordenado por ordem crescente.
	 * @author Anderson
	 */
	public int[] BubbleSortA(int[] array) {

		int aux = 0;

		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					aux = array[j];
					array[j] = array[j + 1];
					array[j + 1] = aux;
				}
			}

		}

		return array;
	}

	/**
	 * Método que ordena um array de inteiros.
	 * 
	 * @param array
	 *            Matriz passado pelo usuário.
	 * @return Um array ordenado por ordem crescente.
	 * @author Emmanuel Kant
	 */
	public int[] BubbleSortE(int[] array) {

		int assist = 0;
		boolean haveChanges;

		do {
			haveChanges = false;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					assist = array[i];
					array[i] = array[i + 1];
					array[i + 1] = assist;
					haveChanges = true;
				}
			}
		} while (haveChanges);

		return array;
	}

}
