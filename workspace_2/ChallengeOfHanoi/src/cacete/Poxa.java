package cacete;

import java.util.Stack;
import java.util.Scanner;

public class Poxa {

	// pilha de comandos que substitui as chamadas recursivas
	private static Stack<String> pilha = new Stack<String>();

	// armazena o número no movimento atual
	private static long numMov; 

	// Método que realiza (imprime) o movimento
	// de um disco entre dois pinos
	private static void mover(int O, int D) {
		numMov++;
		System.out.println("[" + numMov + "]:" + O + " -> " + D);
	}

	// método que implementa o algoritmo hanoi iterativo
	public static void hanoi(int n) {

		int Origem = 1; // pino origem
		int Destino = 3; // pino destino
		int Trabalho = 2; // pino trabalho

		// monta e empilha o primeiro comando
		String comandoAtual = n + "," + Origem + "," + Destino + "," + Trabalho;

		pilha.push(comandoAtual);

		// o jogo chega ao fim quando a pilha de comandos estiver vazia!
		while (!pilha.empty()) {

			// quando n > 1, devemos empilhar um novo comando
			if (n > 1) {

				// monta o novo comando a ser empilhado
				n--;
				String[] vetAux = comandoAtual.split(",");
				Origem = Integer.parseInt(vetAux[1]);
				Destino = Integer.parseInt(vetAux[2]);
				Trabalho = Integer.parseInt(vetAux[3]);

				// isto seria uma chamada recursiva...
				comandoAtual = n + "," + Origem + "," + Trabalho + "," + Destino;

				// empilha o novo comando
				pilha.push(comandoAtual);

				// caso contrário, devemos desempilhar
				// e executar um movimento
			} else {

				// desempilha um comando
				comandoAtual = (String) pilha.pop();

				// separa n, origem, destino e trabalho
				String[] vetAux = comandoAtual.split(",");
				n = Integer.parseInt(vetAux[0]);
				Origem = Integer.parseInt(vetAux[1]);
				Destino = Integer.parseInt(vetAux[2]);
				Trabalho = Integer.parseInt(vetAux[3]);

				// executa movimento
				mover(Origem, Destino);

				// quando n > 1, é preciso empilhar
				// um comando depois do movimento
				if (n > 1) {
					n--;
					// isto seria uma chamada recursiva...
					comandoAtual = n + "," + Trabalho + "," + Destino + "," + Origem;
					pilha.push(comandoAtual);
				}

			}

		}

	}

	// método main para restar o programa!
	public static void main(String[] args) {

		int n; // número de discos

		// recebe o nú mero de discos digitado pelo usuário
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o número de discos: ");
		n = entrada.nextInt();

		// executa o algoritmo iterativo das Torres de Hanói
		Poxa.hanoi(n);

	}

}