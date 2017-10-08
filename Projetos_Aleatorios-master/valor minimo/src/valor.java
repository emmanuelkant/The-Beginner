import java.util.Scanner;

public class valor {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] numeros = new int[10];
		for (int i = 0; i <= numeros.length; i++) {
			System.out.println("Digite o valor " + (i + 1) + ": ");
			numeros[i] = s.nextInt();
			int valor = util.min(numeros);
			System.out.println(valor);
			s.close();
		}
	}
}