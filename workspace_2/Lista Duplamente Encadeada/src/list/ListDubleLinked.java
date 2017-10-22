package list;

public class ListDubleLinked {

	private Node head;
	private Node tail;
	private int countSize;

	/**
	 * Adiciona um nó na próxima posição livre.
	 * 
	 * @param content
	 *            Conteúdo do produto a ser inserido no nó.
	 */
	public void add(Product content) {
		if (countSize == 0) {
			addOnStart(content);
		} else {
			Node newNode = new Node(content, null, this.tail);
			this.tail.setNext(newNode);
			this.tail = newNode;
			this.countSize++;
		}
	}

	/**
	 * Método que adiciona um nó na posição especifica.
	 * 
	 * @param content
	 *            Conteúdo do produto a ser inserido no nó.
	 * @param position
	 *            Posição escolhida pelo usuário.
	 */
	public void add(Product content, int position) {
		if (position == 0) {
			addOnStart(content);
		} else if (position == this.countSize) {
			add(content);
		} else {
			Node positionNode = getNode(position);
			Node newNode = new Node(content, positionNode, positionNode.getPrevious());
			positionNode.getPrevious().setNext(newNode);
			positionNode.setPrevious(newNode);
			this.countSize++;
		}
	}

	/**
	 * Método que adiciona no início da lista, mesmo se stiver vazia.
	 * 
	 * @param content
	 *            Conteúdo do produto a ser inserido no nó.
	 */
	public void addOnStart(Product content) {
		Node newNode = new Node(content, null, null);
		newNode.setNext(this.head);
		this.head = newNode;
		this.head.setPrevious(newNode);
		if (countSize == 0) {
			this.tail = this.head;
		}
		this.countSize++;
	}

	/**
	 * Remove um index da lista na posição que o usuário definir.
	 * 
	 * @param position
	 *            Posição escolhida pelo usuário.
	 */
	public void remove(int position) {
		if (position == 0) {
			removeOnStart(position);
		} else if (position == this.countSize) {
			removeOnBack(position);
		} else {
			Node removedNode = getNode(position);
			removedNode.getPrevious().setNext(removedNode.getNext());
			removedNode.getNext().setPrevious(removedNode.getPrevious());
			removedNode.setNext(null);
			this.countSize--;
		}
	}

	/**
	 * Método que percorre e seleciona um nó definido pelo index da posição
	 * passada.
	 * 
	 * @param position
	 *            Posição do index a ser selecionada.
	 * @return Hum (1) nó.
	 */
	private Node getNode(int position) {
		Node tempNode = this.head;
		for (int i = 0; i < position; i++) {
			tempNode = tempNode.getNext();
		}
		return tempNode;
	}

	/**
	 * Remove o último item da lista.
	 * 
	 * @param position
	 *            Posição do index a ser selecionada.
	 */
	private void removeOnBack(int position) {
		if (this.countSize == 1) {
			removeOnStart(position);
		} else {
			Node removedNode = this.tail;
			removedNode.getPrevious().setNext(null);
			this.tail = removedNode.getPrevious();
			removedNode.setPrevious(null);
			this.countSize--;
		}
	}

	/**
	 * Método que remove um item no começo da lista.
	 * 
	 * @param position
	 *            Posição do index a ser selecionada.
	 */
	private void removeOnStart(int position) {
		if (this.countSize == 0) {
			System.out.println("A lista está vazia.");
		} else {
			Node removedNode = this.head;
			removedNode.getNext().setPrevious(null);
			this.head = removedNode.getNext();
			removedNode.setNext(null);
			this.countSize--;
			if (this.countSize == 0) {
				this.tail = null;
			}
		}
	}

	public int size() {
		return this.countSize;
	}

	@Override
	public String toString() {
		Node nodeToWrite = this.head;
		String string = "";
		for (int i = 0; i < size(); i++) {
			string += nodeToWrite.getContent().getName() + " ";
			nodeToWrite = nodeToWrite.getNext();
		}
		return string;
	}

}
