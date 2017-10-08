
public class Cliente {

	private String nome;
	private String cpf;
	private String empresa;
	
	public Cliente(String nome) {
		this.nome = nome;
	}

	public Cliente(String nome, String cpf, String empresa) {
		this.nome = nome;
		this.cpf = cpf;
		this.empresa = empresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	
}
