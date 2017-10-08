
public class Equacoes {

	public static boolean first(boolean q, boolean r) {
		System.out.println("\nPrimeiro veremos o resultado dessa equacao separadamente --> (Q^R)");
		if (q && r) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean second(boolean p, boolean q) {
		System.out.println("\nAgora veremos o resultado dessa equacao separadamente --> (PvQ)");
		if (p || q) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean third(boolean p, boolean r) {
		System.out.println("\nAgora veremos o resultado dessa equacao separadamente --> (PvR)");
		if (p || r) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean fourth(boolean p, boolean qANDr) {
		System.out.println("\nAgora veremos o resultado dessa equacao separadamente --> Pv(Q^R)");
		if (p || qANDr) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean fiveth(boolean pORq, boolean pORr) {
		System.out.println("\nAgora veremos o resultado dessa equacao separadamente --> (PvQ)^(PvR)");
		if (pORq && pORr) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean sixth(boolean p_OR_qANDr, boolean pORq_AND_pORr) {
		System.out.println("\nAgora veremos o resultado completo da equação original --> Pv(Q^R)<->(PvQ)^(PvR)\n");
		if (p_OR_qANDr == true && pORq_AND_pORr == true || p_OR_qANDr == false && pORq_AND_pORr == false) {
			return true;
		} else {
			return false;
		}
	}
}
