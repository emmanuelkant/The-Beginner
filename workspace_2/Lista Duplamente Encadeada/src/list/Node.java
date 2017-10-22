package list;

public class Node {

	private Node next;
	private Node previous;
	private Product content;

	/**
	 * Construtor da classe Node.
	 * 
	 * @param next
	 *            Referêcia o próximo nó da lista.
	 * @param previous
	 *            Referêcia o nó anterior da lista.
	 * @param content
	 *            Conteúdo do nó do tipo Product.
	 */
	public Node(Product content, Node next, Node previous) {
		this.content = content;
		this.next = next;
		this.previous = previous;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Product getContent() {
		return content;
	}

	public void setContent(Product content) {
		this.content = content;
	}

}
