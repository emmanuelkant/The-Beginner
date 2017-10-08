
public class util {
	public static int min(int[] numeros) {
		int min = numeros[0];
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] < min)
				min = numeros[i];
		}
		return min;
	}

	public static int max(int[] numeros) {
		int max =numeros[0];
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] > i)
				max = numeros[i];
		}
		return max;
	}

	public static int med(int[] numeros) {
		int soma = 0, med;
		for (int i = 0; i < numeros.length; i++) {
			soma = soma + numeros[i];
		}
		med = soma / numeros.length;
		return med;
		
	}
}
