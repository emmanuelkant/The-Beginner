import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String jogador1 = null, jogador2 = null;
		int counter = 0;// DEFININDO O VALOR PRÉVIO DE COUNTER PARA QUE HAJA SOMENTE 9 JOGADAS
		boolean deuvelha = false;
		String[][] tabuleiro = Utility.montaTabuleiro(3);
		
		Utility.mostraTabuleiro(tabuleiro);
		Introducao.mostraPainel();
		jogador1 = Introducao.pegaNome(jogador1);
		jogador2 = Introducao.pegaNome(jogador1);
		Introducao.confirmacao(jogador1, jogador2);
		Utility.mostraTabuleiro(tabuleiro);
		while (counter < 9) {
			// ------------------JOGADA DO PRIMEIRO JOGADOR------------------------------
			Jogadas.fazJogadaJogador1(tabuleiro,jogador1);
			counter = counter + 1;// A CADA JOGADA EU ADICIONO 1 AO CONTADOR
			deuvelha = Verifica_Ganhador.verificaJogador1(tabuleiro);//VERIFICA SE ESSA JOGADA É A JOGADA CAMPEÃ
			if (deuvelha == true) {
				Utility.mostraTabuleiro(tabuleiro);// O TABULEIRO AQUI É MOSTRADO PELA ÚLTIMA VEZ
				System.out.println("\n\n\n------>!!!PARABÉNS " + jogador1.toUpperCase().trim() + " VOCÊ GANHOU!!!<------");
				break;
			}
			if (counter == 9) {// VERIFICO SE A ÚLTIMA JOGADA É A ÚLTIMA
				Utility.mostraTabuleiro(tabuleiro);// O TABULEIRO AQUI É MOSTRADO PELA ÚLTIMA VEZ
				break;
			}
			Utility.mostraTabuleiro(tabuleiro);
			// -----------------JOGADA DO SEGUNDO JOGADOR---------------------------------
			Jogadas.fazJogadaJogador2(tabuleiro,jogador2);
			counter = counter + 1;// A CADA JOGADA EU ADICIONO 1 AO CONTADOR
			deuvelha = Verifica_Ganhador.verificaJogador2(tabuleiro);//VERIFICA SE ESSA JOGADA É A JOGADA CAMPEÃ
			if (deuvelha == true) {
				Utility.mostraTabuleiro(tabuleiro);// O TABULEIRO AQUI É MOSTRADO PELA ÚLTIMA VEZ
				System.out.println("\n\n\n------>!!!PARABÉNS " + jogador2.toUpperCase().trim() + " VOCÊ GANHOU!!!<------");
				break;
			}
			if (counter == 9) {// VERIFICO SE A ÚLTIMA JOGADA É A ÚLTIMA
				Utility.mostraTabuleiro(tabuleiro);// O TABULEIRO AQUI É MOSTRADO PELA ÚLTIMA VEZ
				break;
			}
			Utility.mostraTabuleiro(tabuleiro);
		}
		Utility.verificaDeuVelha(deuvelha);
		Utility.finalizacao();
		in.close();
	}

}
