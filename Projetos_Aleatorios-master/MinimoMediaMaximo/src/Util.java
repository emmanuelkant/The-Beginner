import java.util.Scanner;

public class Util {

	public static int[] pegaValores(int a) {
		Scanner ler = new Scanner(System.in);				
		int[] a1 = new int[a];
		for (int i = 0; i < a1.length; i++) {
			System.out.print("Digite o numero " + (i + 1) + ": ");
			a1[i] = ler.nextInt();
		}
		ler.close();
		return a1;
	}
	
	public static int min(int[] array) {
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}

	public static int max(int[] array) {
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	public static int media(int[] array) {
		int soma = 0, media = 0;
		for (int i = 0; i < array.length; i++) {
			soma = soma + array[i];
		}
		media = soma / array.length;
		return media;
	}
}
