package pacote;
import java.util.Vector;

public class Ordenacao {
	
	private static Vector<Integer> list = new Vector<Integer>();

	public static void main(String[] args) {

		list.addElement(9);
		list.addElement(2);
		list.addElement(6);
		list.addElement(5);
		list.addElement(0);
		list.addElement(4);
		list.addElement(3);
		list.addElement(8);
		list.addElement(1);
		list.addElement(7);

		System.out.println(list.toString());

		bubbleSort();

		System.out.println(list.toString());
		
	}

	private static void bubbleSort() {
		boolean keepWork;
		do {
			keepWork = false;
			for (int i = 0; i < list.size(); i++) {
				int j = i + 1;
				if (i != (list.size() - 1)) {
					if (list.get(i) > list.get(j)) {
						list.insertElementAt(list.get(j), i);
						list.removeElementAt(++j);
						keepWork = true;
					}
				}
			}
		} while (keepWork);
	}
	
	

}
