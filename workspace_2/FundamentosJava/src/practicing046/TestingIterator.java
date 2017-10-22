package practicing046;

import java.util.ArrayList;
import java.util.Iterator;

public class TestingIterator {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();
		list.add("Kant");
		list.add("Júlia");
		list.add("Paulo");
		list.add("Ivani");
		list.add("Didi");
		list.add("Arthur");

		System.out.println("\nLista impressa por meio do Iterator.\n");

		/*
		 * O {@code Iterator} serve para quando queremos percorrer uma lista,
		 * porém sua maoir eficácia é quando estamos tratando de listas e de de
		 * Arrays, pois este útimo possui indices, já as listas possuem apenas
		 * nós.
		 */
		Iterator<String> test = list.iterator();
		while (test.hasNext()) {
			String name = test.next();
			System.out.print(name + " ");
		}

		System.out.println("\n\nLista impressa por meio do foreach.\n");

		/*
		 * O código acima se equipara a este aqui.
		 */
		for (String name : list) {
			System.out.print(name + " ");
		}
	}

}
