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
	 * M�todo que adiciona no final.
	 * 
	 * @param content
	 *            Produto escolhido pelo usu�rio.
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
	 * M�todo que adiciona na posi��o especifica.
	 * 
	 * @param pos
	 *            Posi��o escolhida pelo usu�rio.
	 * @param content
	 *            Produto escolhido pelo usu�rio.
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
	 * Pega um n� na posi��o espec�fica.
	 * 
	 * @param position
	 *            Posi��o escolhida pelo usu�rio.
	 * @return O n� selecionado pela posi��o.
	 */
	private Node getNode(int position) {
		Node tempNode = this.head;
		for (int i = 0; i < position; i++) {
			tempNode = tempNode.getNext();
		}
		return tempNode;
	}

	/**
	 * M�dodo que adiciona no in�cio da lista.
	 * 
	 * @param content
	 *            Produto escolhido pelo usu�rio.
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
	 * M�todo que remove um n�.
	 * 
	 * @param pos
	 *            Posi��o escolhida pelo usu�rio.
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
	 * M�todo que remove um n� do final da lista.
	 * 
	 * @param pos
	 *            Posi��o escolhida pelo usu�rio.
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
	 * M�todo que remove um n� no in�cio dalista.
	 * 
	 * @param pos
	 *            Posi��o escolhida pelo usu�rio.
	 */
	private void removeOnStart(int pos) {
		Node tempNode = this.head.getNext();
		this.head = tempNode;
	}

	/**
	 * M�todo que remove um n� no meio da lista.
	 * 
	 * @param pos
	 *            Posi��o escolhida pelo usu�rio.
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
	 * M�todo que procura o objeto na lista.
	 * 
	 * @param list
	 *            Recebe uma lista para ser varrida.
	 * @param key
	 *            Objeto � ser procurado.
	 * @return False caso o objeto n�o exista na lista e true caso o objeto
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
	 * M�todo que recebe uma lista, j� ordenada, e realiza uma busca bin�ria.
	 * Dividindo a lista sempre na metade e verificando se o elemento buscado
	 * est� na posi��o que ele est� atualmente. Caso o elemento n�o seja o
	 * procurado, ele verifica para qual lado o elemento se encontra, se � para
	 * esquerda eu para a direita da lista.
	 * 
	 * @param list
	 *            Recebe uma lista, j� ordenada, para ser varrida.
	 * @param key
	 *            Objeto � ser procurado
	 * @return True caso o valor seja achado ou false se o elemento n�o estiver
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
	 * M�todo que ordena a lista usando a topologia BubbleSort, ordenando por
	 * ordem alfab�tica.
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
	 * M�todo que guarda o tamanho da lista.
	 * 
	 * @return Retorna a quantidad e n�s.
	 */
	private int size() {
		return countSize;
	}

	/**
	 * M�todo que retorna uma string com todas os valores dos objetos dessa
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
