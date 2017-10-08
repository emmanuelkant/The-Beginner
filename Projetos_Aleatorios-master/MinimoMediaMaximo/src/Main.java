import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		System.out.print("Informe a quantidade de valores que deseja inserir: ");
		int ar = ler.nextInt();
		
		int[] a = Util.pegaValores(ar);		
		int valorMinimo = Util.min(a);
		int valorMaximo = Util.max(a);
		int media = Util.media(a);
		
		System.out.println("O valor maximo é " + valorMaximo);
		System.out.println("O valor minimo é " + valorMinimo);
		System.out.println("A media é " + media);
		
		ler.close();
	}

}
