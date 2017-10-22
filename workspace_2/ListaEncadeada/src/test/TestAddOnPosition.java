package test;

import list.LinkedList;
import list.Product;

public class TestAddOnPosition {
	
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		Product p1 = new Product("Arroz");
		Product p2 = new Product("Feijão");
		Product p3 = new Product("Batata");
		Product p4 = new Product("Bobo");
		Product p5 = new Product("Pizza");
		Product p6 = new Product("Hamburgue");
		Product p7 = new Product("Aveia");
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		list.add(p6);
		list.add(p7);
		
		System.out.println(list.toString());
		
		Product p8 = new Product("Bolo");
		list.add(0, p8);
		
		System.out.println(list.toString());

		
	}

}
