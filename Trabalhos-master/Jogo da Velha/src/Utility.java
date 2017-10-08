import java.util.Scanner;

public class Utility {
	public static void mostraTabuleiro(String[][] tabuleiro) {
		for (int i = 0; i < 3; ++i) {
			System.out.println("|_" + tabuleiro[i][0] + "_|_" + tabuleiro[i][1] + "_|_" + tabuleiro[i][2] + "_|");
		}
	}
	public static String[][] montaTabuleiro(int a) {
		String[][] tabuleiro = new String[a][a];
		for (int i = 0; i < tabuleiro.length; ++i) {
			for (int j = 0; j < tabuleiro.length; j++) {
				tabuleiro[i][j] = "_";
			}
		}
		return tabuleiro;
	}
	public static void realizaJogada1(String[][] tabuleiro, int linha, int coluna){
		tabuleiro[linha - 1][coluna - 1] = "X";// SOMENTE APÓS TODAS AS VERIFICACOES, A JOGADA É DE FATO ATRIBUIDA AO TABULEIRO
	}
	public static void realizaJogada2(String[][] tabuleiro, int linha, int coluna){	
		tabuleiro[linha - 1][coluna - 1] = "O";// SOMENTE APÓS TODAS AS VERIFICACOES, A JOGADA É DE FATO ATRIBUIDA AO TABULEIRO	
	}
	public static void finalizacao(){
		System.out.println("\n\n\n------>GAME OVER<------");
		System.out.println("\n\n------>OBRIGADO POR JOGAR<------");
		System.out.println("\n------>BY EMMANUEL KANT<------");
	}
	public static void verificaDeuVelha(boolean deuvelha){
		if (deuvelha == false) {// VERIFICO SE DEU VELHA
			System.out.println("!!!!!!SHIIIIIIII DEU VELHA!!!!!!!!");
		}
	}

}
