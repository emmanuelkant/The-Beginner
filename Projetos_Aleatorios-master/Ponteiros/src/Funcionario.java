import java.util.Date;

public class Funcionario {

	private String nome;
	private Date dataNascimento;
	private String cargo;

	public Funcionario(String nome, Date dataNascimento, String cargo) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cargo = cargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
