package list;

public class DLinkedList {

	private Node head;
	private Node tail;
	private int countSize = 0;

	public void insertHead(int content) {

		Node newNode = new Node(null, content, this.head);

		if (this.countSize == 0) {
			this.head = newNode;
			this.tail = this.head;
		} else {
			this.head.setPrevious(newNode);
			this.head = newNode;
		}

		countSize++;

	}

	public void insertTail(int content) {

		if (this.countSize == 0) {
			this.insertHead(content);
		} else {

			Node newNode = new Node(this.tail, content, null);
			this.tail.setNext(newNode);
			this.tail = newNode;
			this.countSize++;
		}
	}

	public void insertPosition(int position, int content) {

		if (position == 0) {
			this.insertHead(content);
		} else if (position == this.countSize) {
			this.insertTail(content);
		} else {

			Node temp1 = this.getNode(position - 1);
			Node temp2 = temp1.getNext();

			Node newNode = new Node(temp1, content, temp2);
			temp1.setNext(newNode);
			temp2.setPrevious(newNode);

			this.countSize++;
		}

	}

	public Node getNode(int position) {

		Node temp = this.head;

		for (int i = 0; i < position; i++) {
			temp = temp.getNext();
		}

		return temp;
	}

	public void removeHead() {
		if (this.countSize == 0) {
			System.out.println("A lista está vazia");
		} else {
			Node temp = this.head;
			this.head = temp.getNext();

			temp.setNext(null);
			head.setPrevious(null);

			this.countSize--;

			if (countSize == 0) {
				this.tail = null;
			}
		}
	}

	public void removeTail() {

		if (countSize <= 1) {
			this.removeHead();
		} else {
			Node temp = this.tail.getPrevious();
			temp.setNext(null);
			this.tail.setPrevious(null);
			this.tail = temp;

			this.countSize--;
		}
	}

	public void remove(int position) {

		if (position == 0) {
			this.removeHead();
		} else if (position == countSize - 1) {
			this.removeTail();
		} else {

			Node node = this.getNode(position);
			Node temp1 = node.getPrevious();
			Node temp2 = node.getNext();

			temp1.setNext(temp2);
			temp2.setPrevious(temp1);

			node.setNext(null);
			node.setPrevious(null);

			this.countSize--;
		}
	}

	public String toString() {

		Node temp = this.head;
		String list = "";

		for (int i = 0; i < countSize; i++) {
			list += temp.getContent() + " ";
			temp = temp.getNext();
		}

		return list;
	}

	public boolean linearSearch(int key) {

		Node tmp = this.head;

		for (int i = 0; i < this.countSize; i++) {
			if (tmp.getContent() == key) {
				return true;
			}

			tmp = tmp.getNext();
		}

		return false;

	}

	public boolean binarySearch(int key) {

		int first = 0;
		int last = this.countSize - 1;
		int middle;

		while (first <= last) {
			middle = (first + last) / 2;
			int middleContent = getNode(middle).getContent();

			if (key == middleContent) {
				return true;
			}

			if (key < middleContent) {
				last = middle - 1;
			} else {
				first = middle + 1;
			}
		}

		return false;

	}

	public void bubbleSort() {

		for (int i = 0; i < this.countSize; i++) {

			for (int j = 0; j < this.countSize - 1; j++) {

				Node tmp1 = getNode(j);
				Node tmp2 = getNode(j + 1);

				if (tmp1.getContent() > tmp2.getContent()) {

					tmp1.setNext(tmp2.getNext());

					/*------------------------------------
					 *-----EXERCÍCIO SEM ALTERAÇÃO--------
					 *------------------------------------
					 */

					// if(tmp1 == this.head){
					// tmp2.setNext(tmp1);
					// tmp2.getNext().setPrevious(tmp1);
					// tmp2.setPrevious(null);
					// tmp1.setPrevious(tmp2);
					// this.head = tmp2;
					// } else if(tmp2 == this.tail){
					// tmp2.setNext(tmp1);
					// tmp2.setPrevious(tmp1.getPrevious());
					// tmp1.getPrevious().setNext(tmp2);
					// tmp1.setPrevious(tmp2);
					//// tmp1.setNext(null);
					// this.tail = tmp1;
					// } else {
					// tmp2.getNext().setPrevious(tmp1);
					// tmp2.setNext(tmp1);
					// tmp1.getPrevious().setNext(tmp2);
					// tmp2.setPrevious(tmp1.getPrevious());
					// tmp1.setPrevious(tmp2);
					// }

					/*------------------------------------------------
					 *-----SOMENTE CERTO APENAS PARA FUNCIONAR--------
					 *------------------------------------------------
					 */

					// if(tmp1 == this.head){
					// tmp2.getNext().setPrevious(tmp1);
					// tmp2.setNext(tmp1);
					// tmp2.setPrevious(null);
					// tmp1.setPrevious(tmp2);
					// this.head = tmp2;
					// } else if(tmp2 == this.tail){
					// tmp2.setNext(tmp1);
					// tmp2.setPrevious(tmp1.getPrevious());
					// tmp1.getPrevious().setNext(tmp2);
					// tmp1.setPrevious(tmp2);
					// tmp1.setNext(null);
					// this.tail = tmp1;
					// } else {
					// tmp2.getNext().setPrevious(tmp1);
					// tmp2.setNext(tmp1);
					// tmp1.getPrevious().setNext(tmp2);
					// tmp2.setPrevious(tmp1.getPrevious());
					// tmp1.setPrevious(tmp2);
					// }

					/*---------------------------------
					 *-----CERTO COM ALTERAÇÕES--------
					 *---------------------------------
					 */

					if (tmp2 == this.tail) {
						tmp2.setNext(tmp1);
						tmp2.setPrevious(tmp1.getPrevious());
						tmp1.getPrevious().setNext(tmp2);
						tmp1.setNext(null);
						this.tail = tmp1;
					} else {
						tmp2.getNext().setPrevious(tmp1);
						tmp2.setNext(tmp1);
						if (tmp1 == this.head) {
							tmp2.setPrevious(null);
							this.head = tmp2;
						} else {
							tmp1.getPrevious().setNext(tmp2);
							tmp2.setPrevious(tmp1.getPrevious());
						}
					}
					tmp1.setPrevious(tmp2);

				}

			}

		}

	}

}
