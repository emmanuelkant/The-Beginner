package practicing046;

import java.util.ArrayList;
import java.util.Iterator;

public class TestingIterator {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();
		list.add("Kant");
		list.add("J�lia");
		list.add("Paulo");
		list.add("Ivani");
		list.add("Didi");
		list.add("Arthur");

		System.out.println("\nLista impressa por meio do Iterator.\n");

		/*
		 * O {@code Iterator} serve para quando queremos percorrer uma lista,
		 * por�m sua maoir efic�cia � quando estamos tratando de listas e de de
		 * Arrays, pois este �timo possui indices, j� as listas possuem apenas
		 * n�s.
		 */
		Iterator<String> test = list.iterator();
		while (test.hasNext()) {
			String name = test.next();
			System.out.print(name + " ");
		}

		System.out.println("\n\nLista impressa por meio do foreach.\n");

		/*
		 * O c�digo acima se equipara a este aqui.
		 */
		for (String name : list) {
			System.out.print(name + " ");
		}
	}

}
