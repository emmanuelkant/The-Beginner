import java.util.Scanner;

public class Introducao {
	public static void mostraPainel() {
		System.out.println("\n\n_____________________________________");
		System.out.println("                                     ");
		System.out.println("||---------------------------------||");
		System.out.println("||***BEM VINDO AO JOGO DA VELHA****||");
		System.out.println("||---------------------------------||");
		System.out.println("_____________________________________");
	}
	public static String pegaNome(String jogador1) {
		Scanner in = new Scanner(System.in);
		String nome = null;
		if (jogador1 == null) {
			System.out.println("\n\n\nPor favor digite o nome do Jogador 1: ");
			nome = in.nextLine();
		} else {
			System.out.println("Por favor digite o nome do Jogador 2: ");
			nome = in.nextLine();
		}
		return nome;
	}
	public static void confirmacao(String jogador1, String jogador2) {
		Scanner in = new Scanner(System.in);
		System.out.println("\nO Jogador " + jogador1.toUpperCase().trim() + " será o 'X' e o Jogador " + jogador2.toUpperCase().trim() + " será o 'O' OK?");
		System.out.println("");
		in.nextLine();
	}
}
