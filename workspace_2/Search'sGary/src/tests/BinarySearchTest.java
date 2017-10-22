package tests;

import java.util.Random;

import searchs.BinarySearch;
import searchs.RecursiveBinarySearch;
import sort.BubbleSort;

public class BinarySearchTest {

	public static void main(String[] agrs) {

		int[] array = new int[10];

		Random rand = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(10);
			System.out.print(array[i] + " ");
		}

		System.out.println();

		BubbleSort bs = new BubbleSort();

		array = bs.BubbleSortE(array);

//		BinarySearch bn = new BinarySearch();
		
//		System.out.println(bn.binarySearch(array, 52));
		
		RecursiveBinarySearch rbs = new RecursiveBinarySearch();
		System.out.println(rbs.recursiveBinarySearch(array, 5));

	}

}
