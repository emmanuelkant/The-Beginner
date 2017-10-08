package lista;

public class Lista {

	private Produto[] listaProdutos = new Produto[10];
	private int countSize = 0;

	public void add(Produto produto) {
		for (int i = 0; i < listaProdutos.length; i++) {
			if (listaProdutos[i] == (null)) {
				listaProdutos[i] = produto;
				this.countSize++;
				break;
			} else if (i == 9) {
				System.out.println("A lista esta cheia.");
			}
		}
	}

	public void add(int pos, Produto produto) {
		for (int i = countSize - 1; i >= pos; i--) {
			listaProdutos[i + 1] = listaProdutos[i];
		}
		listaProdutos[pos] = produto;
		this.countSize++;
	}

	public void remove(int pos) {
		for (int i = pos; i < countSize - 1; i++) {
			listaProdutos[i] = listaProdutos[i + 1];
		}
		listaProdutos[countSize - 1] = null;
		this.countSize--;
	}

	public boolean contain(Produto produto) {
		for (int i = 0; i < listaProdutos.length; i++) {
			if (listaProdutos[i].getNome() == produto.getNome()) {
				return true;
			}
		}
		return false;
	}

	public int search(Produto produto) {
		for (int i = 0; i < listaProdutos.length; i++) {
			if (listaProdutos[i].getNome() == produto.getNome()) {
				return i;
			}
		}
		return -1;
	}

	public int size() {
		return this.countSize;
	}

	public String toString() {
		String tmp = "";
		for (int i = 0; i < countSize; i++) {
			tmp += listaProdutos[i].getNome() + " ";
		}
		return tmp;
	}

}
