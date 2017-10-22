package fifoStack;

import java.util.NoSuchElementException;

public class LinkedQueue {

	private Node first;
	private Node last;
	private int size;

	/**
	 * Verifica se a lista está vazia.
	 * 
	 * @return {@code True} se estiver vazia e {@code false} se tem conteúdo.
	 */
	public boolean isEmpty() {
		return (first == null);
	}

	/**
	 * Retorna tamanho da lista.
	 * 
	 * @return O tamanho da lista.
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Adiciona um elemento na fila.
	 * 
	 * @param content
	 */
	public void enqueue(int content) {
		Node oldLast = this.last;
		this.last = new Node(content);
		this.last.setNext(null);
		if (isEmpty()) {
			this.first = this.last;
		} else {
			oldLast.setNext(this.last);
		}
		this.size++;

	}

	/**
	 * Remove o primeiro elemento da lista.
	 * 
	 * @return O conteúdo o nó que foi removido.
	 */
	public int dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty.");
		}
		Node oldFirst = this.first;
		this.first = oldFirst.getNext();
		oldFirst.setNext(null);
		this.size--;
		if (isEmpty()) {
			this.first = this.last = null;
		}

		return oldFirst.getContent();
	}

	/**
	 * Verifica quem está dentro da fila.
	 * 
	 * @return O conteúddo do primeiro da lista.
	 */
	public int peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty.");
		}
		return this.first.getContent();
	}

	/**
	 * imprime o conteúddo da classe.
	 */
	public String toString() {
		String str = "";
		Node tempNode = this.first;
		for (int i = 0; i < this.size(); i++) {
			str += tempNode.getContent() + " ";
			tempNode = tempNode.getNext();
		}
		return str;
	}

}
