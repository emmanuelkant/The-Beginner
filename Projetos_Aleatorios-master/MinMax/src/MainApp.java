import java.util.Scanner;

public class MainApp {
	
	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		int numeros, max = 0, min = 1000000000;
		
		for (int i=1; i<10; i++){
			System.out.printf("Informe o numero %d:", i);
			numeros = ler.nextInt();			
			
			if (numeros > max) {				
				max = numeros;				
			}
			
			if (numeros < min) {				
				min = numeros;				
			}
		}
		
		System.out.println("Maior numero é " + max);
		System.out.println("Menor numero é " + min);
		
		ler.close();
	}
	
}
