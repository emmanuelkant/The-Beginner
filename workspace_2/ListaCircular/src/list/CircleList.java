package list;

public class CircleList {

	private Node head;
	private Node tail;
	private int countSize;

	/**
	 * Método que adiciona um nó no final da lista.
	 * 
	 * @param content
	 *            Produto a ser colocado no nó.
	 */
	public void add(Product content) {
		if (this.countSize == 0) {
			addOnStart(content);
		} else {
			Node newNode = new Node(this.tail, content, this.head);
			this.tail.setNext(newNode);
			this.tail = newNode;
			this.head.setPrevious(this.tail);
			this.countSize++;
		}
	}

	/**
	 * Adiciona um nó na posição específica.
	 * 
	 * @param content
	 *            Produto a ser colocado no nó.
	 * @param position
	 *            Posição escolhida pelo usuário.
	 */
	public void add(Product content, int position) {
		if (position == 0) {
			addOnStart(content);
		} else if (position == this.countSize) {
			add(content);
		} else {
			Node tempNode = getNode(position);
			Node newNode = new Node(tempNode.getPrevious(), content, tempNode);
			tempNode.getPrevious().setNext(newNode);
			tempNode.setPrevious(newNode);
			this.countSize++;
		}
	}

	/**
	 * Pega um nó na posição específica.
	 * 
	 * @param position
	 *            Posição escolhida pelo usuário.
	 * @return O nó selecionado pela posição.
	 */
	private Node getNode(int position) {
		Node tempNode = this.head;
		for (int i = 0; i < position; i++) {
			tempNode = tempNode.getNext();
		}
		return tempNode;
	}

	/**
	 * Adicionana um nó no inicío da lista.
	 * 
	 * @param content
	 *            Produto a ser colocado no nó.
	 */
	private void addOnStart(Product content) {
		Node newNode = new Node(this.tail, content, this.head);
		if (this.countSize == 0) {
			this.head = newNode;
			this.tail = this.head;
		} else {
			this.head.setPrevious(newNode);
			this.tail.setNext(newNode);
			this.head = newNode;
		}
		this.countSize++;
	}

	/**
	 * Remove um nó na posição escolhida.
	 * 
	 * @param position
	 *            Posição escolhida pelo usuário.
	 */
	public void remove(int position) {
		int headOrTail = confirmPosition(position);
		if (headOrTail == 0) {
			removeOnStart();
		} else if (headOrTail == 1) {
			removeOnBack();
		} else {
			Node removedNode = getNode(position);
			removedNode.getNext().setPrevious(removedNode.getPrevious());
			removedNode.getPrevious().setNext(removedNode.getNext());
			if (removedNode == this.tail) {
				this.tail = removedNode.getPrevious();
			}
			removedNode.setNext(null);
			removedNode.setPrevious(null);
			this.countSize--;
		}
	}

	/**
	 * Método que confere se a posição escolhida não foi o head ou o tail. Caso
	 * a posição seja o head, ele retornará o valor 0, caso ele seja o tail, ele
	 * retornará 1.
	 * 
	 * @param position
	 *            Posição que o usuário escolheu.
	 * @return 0 caso seja o head ou um caso seja o tail. Caso nenhum dos
	 *         condicionais ifs sejam executados, ele retornará -1, indicando
	 *         que a posição não corresponde nem o head nem o tail.
	 */
	private int confirmPosition(int position) {
		Node temp = getNode(position);
		if (temp == this.head) {
			return 0;
		} else if (temp == this.tail) {
			return 1;
		}
		return -1;
	}

	/**
	 * Remove um nó do final da lista.
	 * 
	 */
	private void removeOnBack() {
		if (this.countSize == 1) {
			removeOnStart();
		} else {
			Node removedNode = this.tail;
			removedNode.getPrevious().setNext(this.head);
			this.tail = removedNode.getPrevious();
			removedNode.setNext(null);
			removedNode.setPrevious(null);
			this.countSize--;
		}
	}

	/**
	 * Remove um nó do inicio da lista.
	 * 
	 */
	private void removeOnStart() {
		if (this.countSize == 1) {
			this.head = null;
			this.tail = this.head;
		} else {
			Node removedNode = this.head;
			removedNode.getNext().setPrevious(this.tail);
			this.head = removedNode.getNext();
			this.tail.setNext(this.head);
			removedNode.setNext(null);
			removedNode.setPrevious(null);
		}
		this.countSize--;
		if (this.countSize == 0) {
			this.tail = null;
		}
	}

	/**
	 * Retorna o tamanho da lista.
	 * 
	 * @return O valor de countSize.
	 */
	public int size() {
		return this.countSize;
	}

	@Override
	public String toString() {
		Node nodeForWrite = this.head;
		String string = "";
		for (int i = 1; i <= size(); i++) {
			string += nodeForWrite.getContent().getName();
			nodeForWrite = nodeForWrite.getNext();
			if (i == size()) {
				string += ".";
			} else {
				string += ", ";
			}
		}
		return string;
	}

}
