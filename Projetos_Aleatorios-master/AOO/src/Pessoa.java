
public class Pessoa {
	private String nome;
	private String endereço;
	private String dataNascimento;
	
	public Pessoa(String nome, String endereço, String dataNascimento) {
		super();
		this.nome = nome;
		this.endereço = endereço;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
}
