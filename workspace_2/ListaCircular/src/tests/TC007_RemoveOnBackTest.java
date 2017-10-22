package tests;

import list.CircleList;
import list.Product;

public class TC007_RemoveOnBackTest {

	public static void main(String[] args) {

		Product p1 = new Product("Arroz");
		Product p2 = new Product("Feijão");
		Product p3 = new Product("Batata");
		Product p4 = new Product("Carne");

		CircleList list = new CircleList();

		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);

		System.out.println(list.toString());

		list.remove(3);

		System.out.println(list.toString());

		list.remove(2);

		System.out.println(list.toString());

		list.remove(1);

		System.out.println(list.toString());

		list.remove(0);

		System.out.println(list.toString() + "Empty List");

	}

}
