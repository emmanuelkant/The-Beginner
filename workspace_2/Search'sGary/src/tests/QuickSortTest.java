package tests;

import java.util.Random;

import sort.QuickSort;

public class QuickSortTest {

	public static void main(String[] args) {

		int[] array = new int[50];
		Random random = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(500);
		}

		for (int aInt : array) {
			System.out.print(aInt + " ");
		}

		QuickSort quickSort = new QuickSort();

		System.out.println("\n");

		quickSort.quickSort(array);

		for (int aInt : array) {
			System.out.print(aInt + " ");
		}

	}

}
