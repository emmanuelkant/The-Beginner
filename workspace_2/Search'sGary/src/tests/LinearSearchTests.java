package tests;

import searchs.LinearSearch;
import java.util.Random;

public class LinearSearchTests {

	public static void main(String[] args) {

		int[] array = new int[10];

		Random rand = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(100);
			System.out.print(array[i] + " ");
		}

		LinearSearch ls = new LinearSearch();
		
		System.out.println("\n" + ls.linearSearch(array, 12));

	}

}
