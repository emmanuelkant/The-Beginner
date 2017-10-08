package phibonacci;

import java.util.Scanner;

public class tentativa3 {
	public static void main(String[] args) {

		int a[] = new int[20];
		Scanner sc = new Scanner(System.in);
		int valor = 0, tentativa = 0;
		String nome;
		int resp;
		resp=0;
		int fase=5;
		System.out.print("Digite seu nome: ");
		nome = sc.next();
		a[0] = 1;
		a[1] = 1;
		for (int i = 2; i < 20; i++) {
			a[i] = a[i - 1] + a[i - 2];
		}
		do {
		 do {	
			 System.out.print("Digite o próximo número da sequência: ");
			for (int i = 0; i <fase; i++){
			System.out.print(" " + a[i] + " ");
			}
			tentativa++;
			valor = sc.nextInt();
			} while (valor != a[fase]);
		 System.out.println("Deseja continuar [sim=1|não=2]");
		 resp =sc.nextInt();
		 fase++;
		} while ((resp==1) && (fase<20));
		System.out.println("Parabéns" + nome + "você acertou!!!");
	System.out.println("numeros de tentativas: "+tentativa);
	
	
	}
}