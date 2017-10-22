package stack;

public class Node {

	private String disc;
	private Node next;
	
	public Node(String content) {
		this.disc = content;
	}

	public String getDisc() {
		return disc;
	}

	public void setDisc(String content) {
		this.disc = content;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	
	
	
}
