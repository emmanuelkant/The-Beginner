package fifoStack;

import java.util.NoSuchElementException;

public class FifoStack {

	private Node head;
	private Node tail;
	private int size;

	public void enQueue(int content) {
		if (isEmpty()) {
			this.tail = new Node(content);
			this.head = this.tail;
			this.head.setNext(this.tail);
			this.tail.setNext(null);
		} else {
			Node test = this.tail;
			this.tail = new Node(content);
			test.setNext(tail);
		}
		this.size++;
	}

	public Node deQueue() {
		if (!isEmpty()){
			this.size--;
			if (this.head.getNext() != null) {
				Node toReturn = this.head.getNext();
				Node newHead = this.head.getNext();
				this.head.setNext(null);
				this.head = newHead;
				return toReturn;
			} else {
				Node toReturn = this.head;
				this.head.setNext(null);
				this.head = null;
				this.tail = null;
				return toReturn;
			}
		} else {
			throw new NoSuchElementException("Stack is empty!");
		}
	}

	public Node peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack is empty!");
		} else {
			return this.tail;
		}
	}

	public boolean isEmpty() {
		return (this.tail == null);
	}

	public String toString() {
		String str = "";
		Node tempNode = this.head;
		for (int i = 0; i < size; i++) {
			str += tempNode.getContent() + " ";
			tempNode = tempNode.getNext();
		}

		return str;
	}

}
