import java.util.Scanner;

public class valor {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numeros3;

		System.out.println("Digite o numero do array: ");
		numeros3 = s.nextInt();

		int[] numeros = new int[numeros3];
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Digite o valor " + (i + 1) + ": ");
			numeros[i] = s.nextInt();
		}
		int valorminimo = util.min(numeros);
		System.out.println(valorminimo);

		int valormaximo = util.max(numeros);
		System.out.println(valormaximo);

		int med = util.med(numeros);
		System.out.println(med);
		s.close();
	}

}
