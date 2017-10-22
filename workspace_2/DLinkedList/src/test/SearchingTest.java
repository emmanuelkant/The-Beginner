package test;

import java.util.Random;

import list.DLinkedList;

public class SearchingTest {

	public static void main(String[] args) {

		Random rand = new Random();
		int size = 10;
		
		DLinkedList list = new DLinkedList();
		
		for(int i = 0; i < size; i++){
			list.insertTail(rand.nextInt(100));
		}

		System.out.println(list.toString());
		
		//System.out.println(list.linearSearch(32));
		
		list.bubbleSort();
		
		System.out.println(list.toString());
		
	}

}









