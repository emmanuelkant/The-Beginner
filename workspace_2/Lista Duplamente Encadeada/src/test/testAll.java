package test;

import list.ListDubleLinked;
import list.Product;

public class testAll {
	
	public static void main(String[] args) {
		Product p1 = new Product("Arroz");
		Product p2 = new Product("Feijão");
		Product p3 = new Product("Bife");
		Product p4 = new Product("Alface");
		Product p5 = new Product("Frango");
		
		ListDubleLinked list = new ListDubleLinked();
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		
		Product p6 = new Product("Azeite");
		Product p7 = new Product("Coca");
		Product p8 = new Product("Azeite");
		Product p9 = new Product("Coca");
		Product p10 = new Product("Azeite");
		Product p11 = new Product("Coca");
//		System.out.println(list.toString());
//		list.remove(5);
		System.out.println(list.toString());
		list.addOnStart(p6);
		System.out.println(list.toString());
		list.addOnStart(p7);
		System.out.println(list.toString());
		list.remove(3);
		System.out.println(list.toString());
		list.remove(0);
		System.out.println(list.toString());
		list.remove(4);
		System.out.println(list.toString());
		list.addOnStart(p11);
		System.out.println(list.toString());
		
	}

}
