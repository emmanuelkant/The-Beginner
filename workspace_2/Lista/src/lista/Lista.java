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
	 * M�todo para adicionar produto na proxima posi��o livre.
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
	 * M�todo que adiciona um produto na posi��o que o usu�rio deseja.
	 * 
	 * @param pos Posi��o que o usu�rio deseja.
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
	 * M�todo para aumentar a lista caso esteja cheia.
	 * 
	 * @param listaProdutosPast Lista que agora � a lista antiga dos produtos.
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
	 * M�todo que remove o item desejado.
	 * 
	 * @param pos Posi��o que o usu�rio deseja.
	 */
	public void remove(int pos) {
		for (int i = pos; i < countSize - 1; i++) {
			listaProdutos[i] = listaProdutos[i + 1];
		}
		listaProdutos[countSize - 1] = null;
		this.countSize--;
	}
	
	/**
	 * M�todo que confirma se a posi��o est� vazia ou n�o.
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
	 * M�todo que busca a posi��o do produto da lista.
	 * 
	 * @param produto Produto vindo do cliente.
	 * @return Retorna a posi��o que o produto est� no array. Caso ele n�o exista ele retornar� o valor padr�o de -1.
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
	 * M�todo que retorna quantos itens tem a lista.
	 * 
	 * @return Retorna a vari�vel que guarda a quantidade de itens na lista
	 */
	public int size() {
		return this.countSize;
	}
	
	/**
	 * M�todo que printa na tela.
	 */
	public String toString() {
		String tmp = "";
		for (int i = 0; i < size(); i++) {
			tmp += listaProdutos[i].getNome() + " ";
		}
		return tmp;
	}

}
