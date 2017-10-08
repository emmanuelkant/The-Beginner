package phibonacci;

import java.util.Scanner;

public class tentativa2 {
	public static void main(String[] args) {

		int a[] = new int[20];
		Scanner sc = new Scanner(System.in);
		int valor = 0, tentativa = 0;
		String nome;
		int resp;
		resp=0;
		int fase=0;
		System.out.print("Digite seu nome: ");
		nome = sc.next();
		a[0] = 1;
		a[1] = 1;
		for (int i = 2; i < 20; i++) {
			a[i] = a[i - 1] + a[i - 2];
		}
		
		 do {	
			System.out.print("Digite o próximo número da sequência: ");
			for (int i = 0; i <5; i++){
			System.out.print(" " + a[i] + " ");
			}
			tentativa++;
			valor = sc.nextInt();
		} while (valor != a[5]);
		 System.out.println("Deseja continuar ? [sim=1|não=2]");
		 resp =sc.nextInt();
		 do {
		 for (int i = 0;i <fase; i++){
			 fase++;
			 System.out.print(a[fase]);
			 }
		} while (resp==1);
		System.out.println("Parabéns você acertou!!!");
	System.out.println("numeros de tentativas: "+tentativa);
	
	
	}
}
