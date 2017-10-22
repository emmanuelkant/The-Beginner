package tree;

public class BinaryTree {

	private Node root;

	public BinaryTree() {
		this.root = null;
	}

	public void insetNode(int data) {

		// Instanciar um novo no
		Node newNode = new Node(data);
		if (this.root == null) {
			this.root = newNode;
		} else {
			Node focusNode = this.root;
			Node parent;
			while (true) {
				/* Guarda o valor do node anterior */
				parent = focusNode;
				/* Entra na tree da esquerda */
				if (data < focusNode.getData()) {
					/* Guarda o valor do filho da esquerda. */
					focusNode = focusNode.getLeftChild();
					/* Verifica se o node que eu acabei de pegar is null */
					if (focusNode == null) {
						/* Armazena de fato o node nessa folha */
						parent.setLeftChild(newNode);
						return;
					}
					/* Entra na tree da direita. */
				} else if (data > focusNode.getData()) {
					/* Guarda o valor do filho da direita. */
					focusNode = focusNode.getRightChild();
					/* Verifica se o node que eu acabei de pegar is null. */
					if (focusNode == null) {
						/* Armazena de fato o node nessa folha */
						parent.setRightChild(newNode);
						return;
					}
				} else {
					return;
				}
			}
		}
	}

	public Node findNode(int data) {
		Node focusNode = this.root;
		while (focusNode.getData() != data) {
			if (data < focusNode.getData()) {
				focusNode = focusNode.getLeftChild();
			} else {
				focusNode = focusNode.getRightChild();
			}
			if (focusNode != null) {
				return null;
			}
		}
		return focusNode;
	}

	public void inOrder(Node focusNode) {
		if (focusNode != null) {
			inOrder(focusNode.getLeftChild());
			System.out.println(focusNode.getData());
			inOrder(focusNode.getRightChild());
		}
	}
	
	public void preOrder(Node focusNode) {
		if (focusNode != null) {
			System.out.println(focusNode.getData());
			inOrder(focusNode.getLeftChild());
			inOrder(focusNode.getRightChild());
		}
	}
	
	public void posOrder(Node focusNode) {
		if (focusNode != null) {
			inOrder(focusNode.getLeftChild());
			inOrder(focusNode.getRightChild());
			System.out.println(focusNode.getData());
		}
	}

	public Node getRoot() {
		return this.root;
	}
}
