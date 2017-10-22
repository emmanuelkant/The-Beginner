package sort;

public class QuickSort {

	public int[] quickSort(int[] array) {
		int first = 0;
		int last = array.length - 1;
		return quickSortAlg(array, first, last);
	}

	private int[] quickSortAlg(int[] array, int first, int last) {
		if (first < last) {
			int pivot = split(array, first, last);
			quickSortAlg(array, first, pivot - 1);
			quickSortAlg(array, pivot + 1, last);
		}
		return array;
	}

	private int split(int[] array, int first, int last) {
		int pivot = array[first];
		int i = first + 1;
		int j = last;
		while (i <= j) {
			if (array[i] <= pivot) {
				i++;
			} else if (array[j] > pivot) {
				j--;
			} else {
				int swap = array[i];
				array[i] = array[j];
				array[j] = swap;
				i++;
				j--;
			}
		}
		array[first] = array[j];
		array[j] = pivot;
		return j;
	}

}
