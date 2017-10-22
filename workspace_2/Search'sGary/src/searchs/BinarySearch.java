package searchs;

public class BinarySearch {

	/**
	 * Divide o array pela metade e verifica se o valor da {@code key} é maior
	 * ou menor que o valor do {@code middle}. Caso seja menor, ele altera o
	 * valor atual de {@code last} para {@code middle} - 1, em caso contrario,
	 * ele altera o valor de atual {@code first} para {@code middle}. Ele
	 * repedirá esse processo até que {@code first} for menor ou igual a
	 * {@code last}.
	 * 
	 * @param array
	 *            Matriz passado pelo usuário.
	 * @param key
	 *            Valor que o método irá buscar.
	 * @return True caso ele esteja no array e false se ele não estiver nesse
	 *         array.
	 */
	public boolean binarySearch(int[] array, int key) {

		int first = 0, last = array.length - 1;

		while (first <= last) {

			int middle = (first + last) / 2;

			if (array[middle] == key) {
				return true;
			} else if (key < middle) {
				last = middle - 1;
			} else {
				first = middle + 1;
			}

		}

		return false;
	}

}
