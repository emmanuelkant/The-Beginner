import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		
	} {
		Scanner s = new Scanner(System.in);
		// ler 10 valore colocar no array
		int[] numeros = new int[10];
		for (int i = 1; i <= 10; i++) {
			System.out.println("Digite o valor " + i + ":");
			numeros[i - 1] = s.nextInt();
			s.close();
		}

	}
}
