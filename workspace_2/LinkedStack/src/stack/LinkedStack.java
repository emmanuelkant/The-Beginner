package stack;

import java.util.NoSuchElementException;

public class LinkedStack {

	/** O primeiro na pilha. */
	private Node top;
	/** Quantos elementos tem no empilhamento. */
	private int size;

	/**
	 * Construtor da classe.
	 */
	public LinkedStack() {
		this.top = null;
		this.size = 0;
	}

	/**
	 * Retorna o tamanho do stack.
	 * 
	 * @return O tamanho do stack.
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Verifica se a lista est� fazia ou n�o.
	 * 
	 * @return True se est� falsa e false se estiver vazia.
	 */
	public boolean isEmpty() {
		return (this.top == null);
	}

	/**
	 * Cria o novo n� que ser� o novo �ltimo e seta ele como sendo o �ltimo.
	 * 
	 * @param content
	 *            Conte�do do novo {@code top}.
	 */
	public void push(int content) {
		Node oldTop = this.top;
		this.top = new Node(content);
		this.top.setNext(oldTop);
		this.size++;
	}

	/**
	 * Retira um n� da pilha.
	 * 
	 * @return o conten�do do n� que foi retirado.
	 */
	public int pop() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack is empty.");
		}
		Node oldTop = this.top;
		int content = oldTop.getContent();
		this.top = oldTop.getNext();
		oldTop.setNext(null);
		this.size--;
		return content;
	}

	/**
	 * Retorna o conte�do do top.
	 * 
	 * @return Conte�do de quem est� no {@code top}.
	 */
	public int peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Stack is empty.");
		}
		return this.top.getContent();
	}

	public String toString() {
		String str = "";
		Node tempNode = this.top;
		for (int i = 0; i < size(); i++){
			str += tempNode.getContent() + "\n";
			tempNode = tempNode.getNext();
		}
		
		return str;
	}
}
