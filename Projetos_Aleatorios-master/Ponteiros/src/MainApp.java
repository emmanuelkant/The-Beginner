import java.text.SimpleDateFormat;
import java.util.Date;

public class MainApp {

	public static void main(String[] args) {

		Cliente c = new Cliente("Emmanuel", "111.222.333-44", "Dell");
		System.out.println("O nome do Cliente �: " + c.getNome());
		System.out.println("O CPF do Cliente �: " + c.getCpf());
		System.out.println("A Empresa do Cliente �: " + c.getEmpresa() + "\n");
		
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");//Esse metodo formata a Date
		Funcionario f = new Funcionario("Jo�o", new Date(), "Analista");
		System.out.println("O nome do funcion�rio �: " + f.getNome());
		System.out.println("A Data de Anivers�rio do funcion�rio �: " + sdf1.format(f.getDataNascimento()));
		System.out.println("A Empresa do funcion�rio �: " + f.getCargo());
		
		
		
	}

}
