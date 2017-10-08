import java.util.Scanner;

public class Utility {
	static Scanner in = new Scanner(System.in);
	public static void finalizacao(){
		System.out.println("\nAPERTE [ENTER] PARA CONTINUAR");
		String wait = in.nextLine();
	}
}
