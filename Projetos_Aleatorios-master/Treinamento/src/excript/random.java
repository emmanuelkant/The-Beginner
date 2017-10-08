package excript;
import java.util.Random;
import java.util.Scanner;

public class random {
	public static void main(String[] args) {
		Random num = new Random();
		for (int i=0;i<=6;i++) {
		    System.out.println(num.nextInt(6)+1);
			System.out.println(num.nextDouble()*50+10);
			System.out.println(num.nextBoolean());
		}
	}
}
