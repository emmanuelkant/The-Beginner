package challenge;

import java.util.Scanner;
import list.Product;
import list.CircleList;
import list.Node;

public class JosephusProblem {

	private static CircleList listOfSoldiers = new CircleList();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Quantos Soldados tem?");
		int soldiresCount = in.nextInt();
		System.out.println("Quantos Saltos vou dar?");
		int jumpsCount = in.nextInt();
		recruitSoldiers(soldiresCount);
		killSoldiersWithHeadShot(jumpsCount);
	}

	/**
	 * Método que popula o array com os soldados.
	 * 
	 * @param soldiresCount
	 *            Números de soldados, escolhido pelo usuário.
	 */
	private static void recruitSoldiers(int soldiresCount) {
		for (int i = 1; i <= soldiresCount; i++) {
			Product soldierTemp = new Product("Soldado_" + i);
			listOfSoldiers.add(soldierTemp);
			
		}
	}

	/**
	 * Método que mmata/remove um soldado do array pulando quantas posições o
	 * usuário escolher.
	 * 
	 * @param jumpsCount
	 *            Número de saltos que o usuário escolheu.
	 */
	private static void killSoldiersWithHeadShot(int jumpsCount) {
		int position = 0;
		System.out.println(listOfSoldiers.toString() + "\n");
		do {
			boolean soldierStayAlive = true;
			for (int i = 0; i <= jumpsCount; i++) {
				if (i == jumpsCount) {
					if (listOfSoldiers.size() <= position) {
						position -= listOfSoldiers.size();
					}
					listOfSoldiers.remove(position);
					soldierStayAlive = false;
				}
				if (soldierStayAlive) {
					position++;
				}
			}
			System.out.println(listOfSoldiers.toString() + "\n");
		} while (listOfSoldiers.size() != 1);

		System.out.println("O sobrevivente é o " + listOfSoldiers.toString());

	}

}
