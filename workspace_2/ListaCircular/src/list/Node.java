package list;

public class Node {

	private Node next;
	private Node previous;
	private Product content;

	public Node(Node previous, Product content, Node next) {
		this.next = next;
		this.previous = previous;
		this.content = content;
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
