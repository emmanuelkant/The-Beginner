package list;

/**
 * Classe da lista encadeada.
 * 
 * @author Emmanuel Kant.
 *
 */
public class LinkedList {

	private Node head;
	private Node tail;
	private int countSize;

	/**
	 * Método que adiciona no final.
	 * 
	 * @param content
	 *            Produto escolhido pelo usuário.
	 */
	public void add(Product content) {
		if (countSize == 0) {
			this.addOnStart(content);
		} else {
			Node newNode = new Node(content, null);
			this.tail.setNext(newNode);
			this.tail = newNode;
			this.countSize++;
		}
	}

	/**
	 * Método que adiciona na posição especifica.
	 * 
	 * @param pos
	 *            Posição escolhida pelo usuário.
	 * @param content
	 *            Produto escolhido pelo usuário.
	 */
	public void add(int pos, Product content) {

		if (pos == countSize - 1) {
			add(content);
		} else if (pos == 0) {
			this.addOnStart(content);
		} else {
			Node preview = this.getNode(pos - 1);
			Node newNode = new Node(content, preview.getNext());
			preview.setNext(newNode);
			countSize++;
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
	 * Médodo que adiciona no início da lista.
	 * 
	 * @param content
	 *            Produto escolhido pelo usuário.
	 */
	public void addOnStart(Product content) {
		Node newNode = new Node(content, this.head);
		this.head = newNode;
		if (countSize == 0) {
			this.tail = newNode;
		}
		countSize++;
	}

	/**
	 * Método que remove um nó.
	 * 
	 * @param pos
	 *            Posição escolhida pelo usuário.
	 */
	public void remove(int pos) {
		if (pos == 0) {
			removeOnStart(pos);
		} else if (pos == this.countSize) {
			removeOnBack(pos);
		} else {
			removeOnMiddle(pos);
		}
	}

	/**
	 * Método que remove um nó do final da lista.
	 * 
	 * @param pos
	 *            Posição escolhida pelo usuário.
	 */
	private void removeOnBack(int pos) {
		Node tempNode = this.head;
		for (int i = 0; i < pos; i++) {
			if (i == (pos - 1)) {
				tempNode.setNext(null);
				this.tail = tempNode;
			}
		}
	}

	/**
	 * Método que remove um nó no início dalista.
	 * 
	 * @param pos
	 *            Posição escolhida pelo usuário.
	 */
	private void removeOnStart(int pos) {
		Node tempNode = this.head.getNext();
		this.head = tempNode;
	}

	/**
	 * Método que remove um nó no meio da lista.
	 * 
	 * @param pos
	 *            Posição escolhida pelo usuário.
	 */
	private void removeOnMiddle(int pos) {
		Node tempNode = this.head;
		Node previousNode = this.head;
		for (int i = 0; i <= pos; i++) {
			if (i == (pos - 1)) {
				previousNode = tempNode;
			} else if (i == pos) {
				previousNode.setNext(tempNode.getNext());
				this.countSize--;
			} else {
				tempNode = tempNode.getNext();
			}
		}
	}

	/**
	 * Método que procura o objeto na lista.
	 * 
	 * @param list
	 *            Recebe uma lista para ser varrida.
	 * @param key
	 *            Objeto à ser procurado.
	 * @return False caso o objeto não exista na lista e true caso o objeto
	 *         exixta.
	 */
	public boolean searchOnList(LinkedList list, Product key) {
		Node tempNode = list.getNode(-1);
		for (int i = 0; i < list.size(); i++) {
			if (tempNode.getContent() == key) {
				return true;
			}
			tempNode = tempNode.getNext();
		}
		return false;
	}

	/**
	 * Método que recebe uma lista, já ordenada, e realiza uma busca binária.
	 * Dividindo a lista sempre na metade e verificando se o elemento buscado
	 * está na posição que ele está atualmente. Caso o elemento não seja o
	 * procurado, ele verifica para qual lado o elemento se encontra, se é para
	 * esquerda eu para a direita da lista.
	 * 
	 * @param list
	 *            Recebe uma lista, já ordenada, para ser varrida.
	 * @param key
	 *            Objeto à ser procurado
	 * @return True caso o valor seja achado ou false se o elemento não estiver
	 *         dentro da lista.
	 */
	public boolean binarySearch(LinkedList list, Product key) {

		int first = 0;
		int last = list.size();
		char firstCharOfKey = key.getName().toUpperCase().charAt(0);
		char firstCharOfsearchedNode;
		for (int i = 0; i < list.size() - 1; i++) {
			Node searchedNode = list.getNode((last + first) / 2);
			if (key == searchedNode.getContent()) {
				return true;
			}
			firstCharOfsearchedNode = getFirstCharOfNode(searchedNode);
			if (firstCharOfKey < firstCharOfsearchedNode) {
				last = (last / 2) - 1;
			} else {
				first = (last / 2) + 1;
			}
		}

		return false;
	}

	/**
	 * Método que ordena a lista usando a topologia BubbleSort, ordenando por
	 * ordem alfabética.
	 * 
	 * @param list
	 *            Lista com todos os elemntos para serem ordenados por ordem
	 *            alfabetica
	 * @return Uma lista ordenada alfabeticamente.
	 */
	public LinkedList orderList(LinkedList list) {
		boolean haveChange;
		do {
			haveChange = false;
			Node tempNode = list.getNode(-1);
			Node nodeForChange = null;
			Node previousNode = null;
			for (int i = 0; i < list.size(); i++) {
				if (tempNode.getNext() != null) {
					nodeForChange = tempNode.getNext();
					char leftElement = getFirstCharOfNode(tempNode);
					char rightElement = getFirstCharOfNode(nodeForChange);
					if (leftElement > rightElement) {
						tempNode.setNext(nodeForChange.getNext());
						nodeForChange.setNext(tempNode);
						if (this.head == tempNode) {
							this.head = nodeForChange;
						} else if (this.tail == nodeForChange) {
							previousNode.setNext(nodeForChange);
							this.tail = tempNode;
						} else {
							previousNode.setNext(nodeForChange);
						}
						haveChange = true;
					}
				}
				if (haveChange) {
					previousNode = nodeForChange;
				} else {
					previousNode = tempNode;
					tempNode = tempNode.getNext();
				}
			}
		} while (haveChange);

		return list;
	}

	private char getFirstCharOfNode(Node tempNode) {
		return tempNode.getContent().getName().toUpperCase().charAt(0);
	}

	/**
	 * Método que guarda o tamanho da lista.
	 * 
	 * @return Retorna a quantidad e nós.
	 */
	private int size() {
		return countSize;
	}

	/**
	 * Método que retorna uma string com todas os valores dos objetos dessa
	 * classe.
	 */
	public String toString() {
		String string = "";
		Node nodeForPrint = this.head;
		for (int i = 0; i < size(); i++) {
			string += nodeForPrint.getContent().getName() + " ";
			nodeForPrint = nodeForPrint.getNext();
		}
		return string;
	}

}
