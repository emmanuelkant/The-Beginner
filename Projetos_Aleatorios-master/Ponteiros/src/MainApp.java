import java.text.SimpleDateFormat;
import java.util.Date;

public class MainApp {

	public static void main(String[] args) {

		Cliente c = new Cliente("Emmanuel", "111.222.333-44", "Dell");
		System.out.println("O nome do Cliente é: " + c.getNome());
		System.out.println("O CPF do Cliente é: " + c.getCpf());
		System.out.println("A Empresa do Cliente é: " + c.getEmpresa() + "\n");
		
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");//Esse metodo formata a Date
		Funcionario f = new Funcionario("João", new Date(), "Analista");
		System.out.println("O nome do funcionário é: " + f.getNome());
		System.out.println("A Data de Aniversário do funcionário é: " + sdf1.format(f.getDataNascimento()));
		System.out.println("A Empresa do funcionário é: " + f.getCargo());
		
		
		
	}

}
