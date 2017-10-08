import java.util.Random;
import java.util.Scanner;

public class Apresentação {
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		int valor = 0, tentativa = 0;
		String nome;
		System.out.print("Digite seu nome: ");
		nome = sc.next();
		int x = rand.nextInt(100);
		while (valor != x ) {
			System.out.print("Tente descobrir o número. Digite um valor: ");
			valor = sc.nextInt();
			if (valor < x ) {
				System.out.println("\nO valor é maior. Tente novamente.");
				tentativa++;
			} else if (valor > x ) {
				System.out.println("\nO valor é menor. Tente novamente.");
				tentativa++;
			} else {
				System.out.println("\nParabéns!! Você acertou.");
				tentativa++;
				System.out.println("Nome: " + nome);
			}
			System.out.println("Tentativas: " + tentativa + "\n");
		}
		System.out.println("Fim da Execução.");
		sc.close();

	}

}
