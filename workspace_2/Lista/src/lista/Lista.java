package lista;

/**
 * Classe da lista com todos os produtos.
 * 
 * @author Emmanuel Kant.
 */
public class Lista {

	private Produto[] listaProdutos = new Produto[10];
	private int countSize = 0;
	
	/**
	 * Método para adicionar produto na proxima posição livre.
	 * 
	 * @param produto Produto vindo do cliente.
	 */
	public void add(Produto produto) {
		for (int i = 0; i < listaProdutos.length; i++) {
			if (listaProdutos[i] == (null)) {
				listaProdutos[i] = produto;
				this.countSize++;
				break;
			} else if (i == 9) {
				aumentaArray(listaProdutos);
			}
		}
	}
	
	/**
	 * Método que adiciona um produto na posição que o usuário deseja.
	 * 
	 * @param pos Posição que o usuário deseja.
	 * @param produto Produto vindo do cliente.
	 */
	public void add(int pos, Produto produto) {
		for (int i = countSize - 1; i >= pos; i--) {
			if (listaProdutos[i + 1] != null) {
				listaProdutos[i + 1] = listaProdutos[i];
			} else {
				aumentaArray(listaProdutos);
				i++;
			}
		}
		listaProdutos[pos] = produto;
		this.countSize++;
	}
	
	/**
	 * Método para aumentar a lista caso esteja cheia.
	 * 
	 * @param listaProdutosPast Lista que agora é a lista antiga dos produtos.
	 */
	private void aumentaArray(Produto[] listaProdutosPast) {
		int newLength = listaProdutosPast.length * 2;
		Produto[] tempo = new Produto[newLength];
		for (int i = 0; i < listaProdutosPast.length; i++) {
			tempo[i] = listaProdutosPast[i];
		}
		this.listaProdutos = tempo;
	}
	
	/**
	 * Método que remove o item desejado.
	 * 
	 * @param pos Posição que o usuário deseja.
	 */
	public void remove(int pos) {
		for (int i = pos; i < countSize - 1; i++) {
			listaProdutos[i] = listaProdutos[i + 1];
		}
		listaProdutos[countSize - 1] = null;
		this.countSize--;
	}
	
	/**
	 * Método que confirma se a posição está vazia ou não.
	 * 
	 * @param produto Produto vindo do cliente.
	 * @return Retorna verdadeiro ou falso.
	 */
	public boolean contain(Produto produto) {
		for (int i = 0; i < listaProdutos.length; i++) {
			if (listaProdutos[i].getNome() == produto.getNome()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Método que busca a posição do produto da lista.
	 * 
	 * @param produto Produto vindo do cliente.
	 * @return Retorna a posição que o produto está no array. Caso ele não exista ele retornará o valor padrão de -1.
	 */
	public int search(Produto produto) {
		for (int i = 0; i < listaProdutos.length; i++) {
			if (listaProdutos[i].getNome() == produto.getNome()) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Método que retorna quantos itens tem a lista.
	 * 
	 * @return Retorna a variável que guarda a quantidade de itens na lista
	 */
	public int size() {
		return this.countSize;
	}
	
	/**
	 * Método que printa na tela.
	 */
	public String toString() {
		String tmp = "";
		for (int i = 0; i < size(); i++) {
			tmp += listaProdutos[i].getNome() + " ";
		}
		return tmp;
	}

}
