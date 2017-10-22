package fifoStack;

public class Node {

	private Node next;
	private int content;
	
	public Node(int content) {
		this.content = content;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getContent() {
		return content;
	}

	public void setContent(int content) {
		this.content = content;
	}
	
	
	
	
}
