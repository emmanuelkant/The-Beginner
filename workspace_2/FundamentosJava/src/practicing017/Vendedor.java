package practicing017;

public class Vendedor extends Funcionario {

	private float comissao;

	public Vendedor(String name, float salario, float comissao) {
		super(name, salario);
		this.comissao = comissao;
	}

	@Override
	public float getSalario() {
		float salarioTotal = super.getSalario();
		return salarioTotal + comissao;
	}

	public float getComissao() {
		return this.comissao;
	}

	public void setComissao(float comissao) {
		this.comissao = comissao;
	}

	@Override
	public String toString() {
		String string = "";
		string += super.getName() + "\n";
		string += getSalario() + "\n";
		string += this.comissao + "%";
		return string;
	}

}
