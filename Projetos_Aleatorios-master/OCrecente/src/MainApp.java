import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		int elementos[] = new int[3];
		int cont1, cont2, aux;
		
		for (int i=0; i<3; i++){
			System.out.print("Informe o numero " + (i + 1) + ": ");
			elementos[i] = ler.nextInt();
		}
		
		for(cont1 = 0; cont1 < 3; cont1++){
			for (cont2 = 0; cont2 < 2; cont2++){
				if(elementos[cont2] > elementos[cont2 + 1]){
					aux = elementos[cont2];
					elementos[cont2] = elementos[cont2 + 1];
					elementos[cont2 + 1] = aux;
				}
			}
		}
			
		System.out.println("Resultado;");
		for (int numero : elementos){
			System.out.println(numero);
		}
		ler.close();
	}
}	
