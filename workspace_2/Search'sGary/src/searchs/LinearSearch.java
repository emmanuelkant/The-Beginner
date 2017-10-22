package searchs;

public class LinearSearch {

	/**
	 * Percorre o array posi��o por posi��o at� que ele encontre o valor de
	 * {@code key}.
	 * 
	 * @param array
	 *            Matriz passado pelo usu�rio.
	 * @param key
	 *            Valor que o m�todo ir� buscar.
	 * @return True caso ele esteja no array e false se ele n�o estiver nesse
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
