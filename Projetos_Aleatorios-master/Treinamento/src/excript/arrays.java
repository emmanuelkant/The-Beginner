package excript;

public class arrays {
	public static void main(String[] args) {
		int[] tabela = new int[5];
		tabela[0] = 25;
		tabela[1] = 30;
		tabela[2] = 35;
		tabela[3] = 40;
		tabela[4] = 44;
		float soma = 0;
		// FOR EACH
		for (int item : tabela) { // item vai receber cada posição do array
			soma += item; // soma vai receber soma + item
			System.out.println(item);
			// calcula a media do array
			float media;
			media = soma / tabela.length; // media vai receber soma dividido por
											// cada posição do array
			System.out.println(media);

			// array de 2 dimensoes
			int array[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
			// cria u for para imprimir cada demensão
			for (int x = 0; x < 3; x++) {
				for (int y = 0; y < 3; y++)
					System.out.print(array[x][y] + "  ");
				System.out.println();
			}

		}
	}
}