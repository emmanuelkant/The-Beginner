package test;

import list.*;

public class TestingBubbleSortOnLinkedList {
	
	public static void main(String[] args) {
		
		Product p1 = new Product("Arroz");
		Product p2 = new Product("Feijão");
		Product p3 = new Product("Batata");
		Product p4 = new Product("Tomate");
		Product p5 = new Product("Pizza");
		Product p6 = new Product("Hambúrguer");
		Product p7 = new Product("Aveia");
		Product p8 = new Product("Macarrão");

		LinkedList list = new LinkedList();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		list.add(p6);
		list.add(p7);
		
		System.out.println(list.toString());
		
		list = list.orderList(list);
		
		System.out.println(list.toString());
		
	}

}
