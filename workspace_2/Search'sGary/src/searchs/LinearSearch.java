package searchs;

public class LinearSearch {

	/**
	 * Percorre o array posição por posição até que ele encontre o valor de
	 * {@code key}.
	 * 
	 * @param array
	 *            Matriz passado pelo usuário.
	 * @param key
	 *            Valor que o método irá buscar.
	 * @return True caso ele esteja no array e false se ele não estiver nesse
	 *         array.
	 */
	public boolean linearSearch(int[] array, int key) {
		for (int valueOfPosition : array) {
			if (valueOfPosition == key) {
				return true;
			}
		}
		return false;
	}

}
