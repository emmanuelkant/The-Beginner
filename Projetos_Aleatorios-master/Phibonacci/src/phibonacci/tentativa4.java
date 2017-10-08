package phibonacci;

import java.util.Scanner;

public class tentativa4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int array;
		String nome;

		System.out.print("Digite seu nome: ");
		nome = sc.next();

		System.out.println("Digite a quantidade de números que a sequência deve ter");
		array = sc.nextInt();

		int a[] = new int[array];
		int valor = 0, tentativa = 0;
		int resp;
		resp = 0;
		int fase = 5;
		a[0] = 1;
		a[1] = 1;
		for (int i = 2; i < array; i++) {
			a[i] = a[i - 1] + a[i - 2];
		}
		do {
			do {
				System.out.print("Digite o próximo número da sequência: ");
				for (int i = 0; i < fase; i++) {
					System.out.print(" " + a[i] + " ");
				}
				tentativa++;
				valor = sc.nextInt();
			} while (valor != a[fase]);
			System.out.println("Deseja continuar [sim=1|não=2]");
			resp = sc.nextInt();
			fase++;
		} while ((resp == 1) && (fase < array));
		System.out.println("Parabéns " + nome + " você acertou!!!");
		System.out.println("numeros de tentativas: " + tentativa);
		sc.close();
	}
}