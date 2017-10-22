package hanoi;

import stack.LinkedStack;

public class Challenge {

	public static void main(String[] args) {

		LinkedStack stackOsActions = new LinkedStack();

		int discToMove = 3;

		stackOsActions.push(discToMove + "132");

		System.out.println("Legenda\n" + "Primeiro numero -> Numero do disco, quanto maior o numero, maior o disco.\n"
				+ "Segundo numero -> Posicao do SOURCE.\n" + "Terceiro numero -> Posicao do DISTINATION.\n"
				+ "Quarto numero -> Posicao do AUXILIARY.\n");

		do {

			if (discToMove > 1) {
				discToMove--;

				String temp = stackOsActions.peek();
				char[] c = temp.toCharArray();
				c[0] = 0;
				char charTemp = c[2];
				c[2] = c[3];
				c[3] = charTemp;
				String newAction = new String(c);
				newAction = newAction.trim();
				stackOsActions.push(discToMove + newAction);

			} else {
				String s = String.valueOf(stackOsActions.peek());
				System.out.println(stackOsActions.pop());
				char aux = s.charAt(0);
				int disc = aux - 48;
				if (disc != discToMove) {
					discToMove = disc;
				}
				if (discToMove > 1) {
					discToMove--;

					char[] c = s.toCharArray();
					c[0] = 0;
					char charTemp = c[1];
					c[1] = c[3];
					c[3] = charTemp;
					String newAction = new String(c);
					newAction = newAction.trim();
					stackOsActions.push(discToMove + newAction);

				}
			}

		} while (!stackOsActions.isEmpty());

	}

}
