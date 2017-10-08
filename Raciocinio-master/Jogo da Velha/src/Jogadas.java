import java.util.Scanner;

public class Jogadas {
	
	public static void fazJogadaJogador1(String[][] tabuleiro, String jogador1) {
		
		int linha, coluna;
		do {
			linha = Jogadas.jogada1_do_Jogador1(jogador1);
			coluna = Jogadas.jogada2_do_Jogador1(jogador1);
			if (tabuleiro[linha - 1][coluna - 1] == "X" || tabuleiro[linha - 1][coluna - 1] == "O") {// SE O LUGAR JÁ ESTA OCUPADO, IMPRIMA
				System.out.println("\nERROR: O lugar selecionado já está ocupado. Por favor escolha outra posição.\n");
			}
		} while (tabuleiro[linha - 1][coluna - 1] == "X" || tabuleiro[linha - 1][coluna - 1] == "O");//SE O LUGAR JÁ ESTA OCUPADO, REPITA
		Utility.realizaJogada1(tabuleiro,linha,coluna);	
	}
	public static void fazJogadaJogador2(String[][] tabuleiro, String jogador2) {
			int linha, coluna;
			do {
				linha = Jogadas.jogada1_do_Jogador1(jogador2);
				coluna = Jogadas.jogada2_do_Jogador1(jogador2);
				if (tabuleiro[linha - 1][coluna - 1] == "X" || tabuleiro[linha - 1][coluna - 1] == "O") {// SE O LUGAR JÁ ESTA OCUPADO, IMPRIMA
					System.out.println("\nERROR: O lugar selecionado já está ocupado. Por favor escolha outra posição.\n");
				}
			} while (tabuleiro[linha - 1][coluna - 1] == "X" || tabuleiro[linha - 1][coluna - 1] == "O");//SE O LUGAR JÁ ESTA OCUPADO, REPITA
			Utility.realizaJogada2(tabuleiro,linha,coluna);	
		}
	public static int jogada1_do_Jogador1(String jogador1) {
		Scanner in = new Scanner(System.in);
		int linha;
		do {
			System.out.print(jogador1.toUpperCase().trim() + " faça sua jogada. Escolha uma LINHA para jogar: ");
			linha = in.nextInt();
			if (linha < 1 || linha > 3) {
				System.out.println("\nERROR: Você deve escolher um número entre 1 e 3 para jogar. Por favor repita a jogada.\n");
			}
		} while (linha < 1 || linha > 3);
		return linha;
	}
	public static int jogada2_do_Jogador1(String jogador1) {

		Scanner in = new Scanner(System.in);
		int coluna;
		do {
			System.out.print(jogador1.toUpperCase().trim() + " faça sua jogada. Escolha uma COLUNA para jogar: ");
			coluna = in.nextInt();
			if (coluna < 1 || coluna > 3) {
				System.out.println("\nERROR: Você deve escolher um número entre 1 e 3 para jogar. Por favor repita a jogada.\n");
			}
		} while (coluna < 1 || coluna > 3);
		return coluna;
	}
	public static int jogada1_do_Jogador2(String jogador2) {
		Scanner in = new Scanner(System.in);
		int linha;
		do {
			System.out.print(jogador2.toUpperCase().trim() + " faça sua jogada. Escolha uma LINHA para jogar: ");
			linha = in.nextInt();
			if (linha < 1 || linha > 3) {
				System.out.println("\nERROR: Você deve escolher um número entre 1 e 3 para jogar. Por favor repita a jogada.\n");
			}
		} while (linha < 1 || linha > 3);
		return linha;
	}
	public static int jogada2_do_Jogador2(String jogador2) {
		Scanner in = new Scanner(System.in);
		int coluna;
		do {
			System.out.print(jogador2.toUpperCase().trim() + " faça sua jogada. Escolha uma COLUNA para jogar: ");
			coluna = in.nextInt();
			if (coluna < 1 || coluna > 3) {
				System.out.println("\nERROR: Você deve escolher um número entre 1 e 3 para jogar. Por favor repita a jogada.\n");
			}
		} while (coluna < 1 || coluna > 3);
		return coluna;
	}
}
