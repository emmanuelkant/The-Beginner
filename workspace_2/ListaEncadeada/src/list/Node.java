package list;

/**
 * Classe do nó.
 * 
 * @author Emmanuel Kant.
 *
 */
public class Node {
	
	private Product content;
	private Node next;
	
	/**
	 * Contrutor de Node.
	 * 
	 * @param content Conteudo vindo do usuário
	 * @param next Referencia para o próximo nó.
	 */
	public Node(Product content, Node next) {
		this.content = content;
		this.next = next;
	}
	
	public Product getContent() {
		return content;
	}
	public void setContent(Product content) {
		this.content = content;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}

	
}
