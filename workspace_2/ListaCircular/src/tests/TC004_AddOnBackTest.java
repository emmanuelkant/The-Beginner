package tests;

import list.CircleList;
import list.Product;

public class TC004_AddOnBackTest {
	
	public static void main(String[] args) {
		
		Product p1 = new Product("Arroz");
		Product p2 = new Product("Feij�o");
		Product p3 = new Product("Batata");
		Product p4 = new Product("Carne");
		
		CircleList list = new CircleList();
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		
		System.out.println(list.toString());
		
		Product p5 = new Product("Ervilha");
		list.add(p5, 4);
		
		System.out.println(list.toString());
	}

}
