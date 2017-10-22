package searchs;

public class RecursiveBinarySearch {

	public boolean recursiveBinarySearch(int[] array, int key) {
		int first = 0;
		int last = array.length - 1;
		return search(array, first, last, key);
	}

	private boolean search(int[] array, int first, int last, int key) {
		int middle = (first + last) / 2;
		int middleContent = array[middle];

		if (first > last) {
			return false;
		} else if (key == middleContent) {
			return true;
		} else if (key < middleContent) {
			return search(array, first, middle - 1, key);
		} else {
			return search(array, middle + 1, last, key);
		}

	}

}
