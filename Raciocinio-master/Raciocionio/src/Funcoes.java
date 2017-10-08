import java.util.Scanner;

public class Funcoes {

	public static boolean pegaValor(int controler) {

		Scanner in = new Scanner(System.in);
		int valor = 0;
		do {
			if (controler == 0) {
				System.out.print("Digite o valor de 'P': ");
				valor = in.nextInt();
			}
			if (controler == 1) {
				System.out.print("Digite o valor de 'Q': ");
				valor = in.nextInt();
			}
			if (controler == 2) {
				System.out.print("Digite o valor de 'R': ");
				valor = in.nextInt();
			}
			if (valor > 1 || valor < 0) {
				System.out.println("\nERROR: Por favor digite o numeor '1' para VERDADEIRO e '0' para FALSO.\n");
			}
		} while (valor > 1 || valor < 0);
		if (valor == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static void intro() {
		Scanner in = new Scanner(System.in);
		System.out.println("\nEsse programa irá¡ resolver este problema --> Pv(Q^R)<->(PvQ)^(PvR)");
		System.out.println("Mas antes digite os valores das preposições P, Q e R.");
		System.out.println("\n\n!!!!!!Atenção!!!!!!\n\n");
		System.out.println("Para selecionar o valor VERDADEIRO: Digite o numero '1' e aperte [ENTER]");
		System.out.println("Para selecionar o valor FALSO: Digite o numero '0' e aperte [ENTER]");
		System.out.print("Aperte [ENTER] para continuar\n");
		String start = in.nextLine();
	}

	public static int mostraValores(boolean p, boolean q, boolean r) {
		Scanner in = new Scanner(System.in);
		System.out.println("\nAs suas escolhas ficaram desta maneira:");
		System.out.println("\nA preposição 'P' ficou com o valor: " + p);
		System.out.println("\nA preposição 'Q' ficou com o valor: " + q);
		System.out.println("\nA preposição 'R' ficou com o valor: " + r);
		System.out.println("\nVocê Confirma suas escolhas? [Digite '1' para SIM e '0' para NÃO]");
		int decision = in.nextInt();
		return decision;
	}

	public static void tabela(boolean p, boolean q, boolean r, boolean qANDr, boolean pORq, boolean pORr, boolean p_OR_qANDr, boolean pORq_AND_pORr, boolean equacaoFinal) {
		Scanner in = new Scanner(System.in);
		//Essa variavel 'prep' que estou criando é o nome reduzido de preposição, irei criar um array de 9 posições.
		char[] prep  = new char[9];
		prep[0] = Funcoes.conversor(p);
		prep[1] = Funcoes.conversor(q);
		prep[2] = Funcoes.conversor(r);
		prep[3] = Funcoes.conversor(qANDr);
		prep[4] = Funcoes.conversor(pORq);
		prep[5] = Funcoes.conversor(pORr);
		prep[6] = Funcoes.conversor(p_OR_qANDr);
		prep[7] = Funcoes.conversor(pORq_AND_pORr);
		prep[8] = Funcoes.conversor(equacaoFinal);
		System.out.println("|_P_|_Q_|_R_|_(Q^R)_|_(PvQ)_|_(PvR)_|_Pv(Q^R)_|_(PvQ)^(PvR)_|_Pv(Q^R)<->(PvQ)^(PvR)_|");
		System.out.println("|_"+prep[0]+"_|_"+prep[1]+"_|_"+prep[2]+"_|___"+prep[3]+"___|___"+prep[4]+"__|___"+prep[5]+"__|____"+prep[6]+"____|_____"+prep[7]+"_____|___________"+prep[8]+"___________|\n\n");
		System.out.print("APERTE [ENTER] PARA FINALIZAR A APLICAÇÃO");
		String finalizacao = in.nextLine();
		System.out.println("-------------------");
		System.out.println("        ----------");
		System.out.println("            -----");
		System.out.println("APLICAÇÃO FINALIZADA");
	}
	
	private static char conversor(boolean x){
		if (x == true){
			return 86;
		}else {
			return 70;
		}
	}
	
	public static void tabelaProvisoria(boolean x, boolean y, boolean z){
		char[] prep = new char[3];
		prep[0] = Funcoes.conversor(x);
		prep[1] = Funcoes.conversor(y);
		prep[2] = Funcoes.conversor(z);
		System.out.println("\n|_Q_|_R_|_(Q^R)_|");
		System.out.println("|_"+prep[0]+"_|_"+prep[1]+"_|___"+prep[2]+"___|");
	}
	
	public static void tabelaProvisoria2(boolean x, boolean y, boolean z){
		char[] prep = new char[3];
		prep[0] = Funcoes.conversor(x);
		prep[1] = Funcoes.conversor(y);
		prep[2] = Funcoes.conversor(z);
		System.out.println("\n|_P_|_Q_|_(PvQ)_|");
		System.out.println("|_"+prep[0]+"_|_"+prep[1]+"_|___"+prep[2]+"___|");
	}
	
	public static void tabelaProvisoria3(boolean x, boolean y, boolean z){
		char[] prep = new char[3];
		prep[0] = Funcoes.conversor(x);
		prep[1] = Funcoes.conversor(y);
		prep[2] = Funcoes.conversor(z);
		System.out.println("\n|_P_|_R_|_(PvR)_|");
		System.out.println("|_"+prep[0]+"_|_"+prep[1]+"_|___"+prep[2]+"__|");
	}
	
	public static void tabelaProvisoria4(boolean x, boolean y, boolean z){
		char[] prep = new char[3];
		prep[0] = Funcoes.conversor(x);
		prep[1] = Funcoes.conversor(y);
		prep[2] = Funcoes.conversor(z);
		System.out.println("\n|_P_|_(Q^R)_|_Pv(Q^R)_|");
		System.out.println("|_"+prep[0]+"_|___"+prep[1]+"___|____"+prep[2]+"___|");
	}
	
	public static void tabelaProvisoria5(boolean x, boolean y, boolean z){
		char[] prep = new char[3];
		prep[0] = Funcoes.conversor(x);
		prep[1] = Funcoes.conversor(y);
		prep[2] = Funcoes.conversor(z);
		System.out.println("\n|_(PvQ)_|_(PvR)_|_(PvQ)^(PvR)_|");
		System.out.println("|___"+prep[0]+"___|__"+prep[1]+"__|______"+prep[2]+"_____|");
	}


}
