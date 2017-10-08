package treino;

import java.util.Scanner;

public class clinica {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String nome;
	int sexo=0,idade=0,qtdpacientes=0;
	int qtdhomens=0,qtdmulheres=0,qtdidade=0;
	float peso=0,altura=0;
	String velhote;
	System.out.println("Digite seu nome");
	nome = in.next();
	do {

		System.out.println("Digite seu sexo  [1=homem] [2=Mulher]");
		sexo = in.nextInt();
		System.out.println("Sexo invalido !!!");
		System.out.println("                ");
		System.out.println("                ");
	} while ((sexo!=1) && (sexo!=2));
	
	
	System.out.println("Digite o seu peso");
	peso = in.nextInt();
	System.out.println("Digite a sua idade");
	idade = in.nextInt();
	System.out.println("Digite a sua altura");
	altura = in.nextInt();
	qtdpacientes++;
	
	while ((idade>18) && (idade>25)) {
		qtdidade++;
	}
	
	while ((sexo==2) && (altura>1.60) && (altura<1.70)) {
		qtdmulheres++;
	}
	while (sexo==1) {
   qtdhomens=(qtdhomens+idade)/2;
	}
	
}
}
