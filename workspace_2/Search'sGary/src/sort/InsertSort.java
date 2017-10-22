package sort;

public class InsertSort {

	public int[] insertionSort(int[] array) {

		for (int i = 1; i < array.length; i++) {

			int key = array[i];

			for (int j = i - 1; (j >= 0) && (array[j] > key); j--) {

				array[j + 1] = array[j];
				array[j] = key;
				
			}

		}

		return array;
	}

}
