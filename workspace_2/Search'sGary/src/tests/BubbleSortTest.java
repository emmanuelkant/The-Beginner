package tests;

import java.util.Random;
import sort.BubbleSort;

public class BubbleSortTest {

	public static void main(String[] args) {

		int[] array = new int[10];

		Random rand = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(100);
			System.out.print(array[i] + " ");
		}
		
		System.out.println();
		
		BubbleSort bs = new BubbleSort();
		
		array = bs.BubbleSortE(array);
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

}
