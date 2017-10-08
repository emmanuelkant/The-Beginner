import java.util.Scanner;

public class Mae {
	
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		String n;
		do {
			System.out.println("Você está bem meu filho?");
			n = ler.nextLine();		
		} while (n != "não");
		System.out.println("Fim.");
		ler.close();
	}

}
