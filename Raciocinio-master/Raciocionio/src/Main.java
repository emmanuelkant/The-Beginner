import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int controler = 0;
		boolean p = true, q = true, r = true;

		Funcoes.intro();
		int decision = 0;
		do {
			p = Funcoes.pegaValor(controler);
			controler += 1;
			q = Funcoes.pegaValor(controler);
			controler += 1;
			r = Funcoes.pegaValor(controler);
			decision = Funcoes.mostraValores(p, q, r);
			if (decision == 0) {
				controler = 0;
				System.out.println("\nEntão digite os valores novamente por favor");
			}
		} while (decision == 0);
		boolean qANDr = Equacoes.first(q, r);
		Funcoes.tabelaProvisoria(q,r,qANDr);
		boolean pORq = Equacoes.second(p, q);
		Funcoes.tabelaProvisoria2(p,q,pORq);
		boolean pORr = Equacoes.third(p, r);
		Funcoes.tabelaProvisoria3(p,r,pORr);
		boolean p_OR_qANDr = Equacoes.fourth(p, qANDr);
		Funcoes.tabelaProvisoria4(p,qANDr,p_OR_qANDr);
		boolean pORq_AND_pORr = Equacoes.fiveth(pORq, pORr);
		Funcoes.tabelaProvisoria5(pORq,pORr,pORq_AND_pORr);
		boolean equacaoFinal = Equacoes.sixth(p_OR_qANDr, pORq_AND_pORr);
		Funcoes.tabela(p, q, r, qANDr, pORq, pORr, p_OR_qANDr, pORq_AND_pORr, equacaoFinal);
	}

}
