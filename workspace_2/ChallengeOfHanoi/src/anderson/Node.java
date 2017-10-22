package anderson;

public class Node {

	private Object disc;
	private Node next;
	
	public Node(Object content) {
		this.disc = content;
	}

	public Object getDisc() {
		return disc;
	}

	public void setDisc(Object content) {
		this.disc = content;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	
	
	
}
