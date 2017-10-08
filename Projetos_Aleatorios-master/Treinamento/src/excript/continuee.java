package excript;

import java.util.Scanner;

public class continuee {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Digte o numero");
		int num = in.nextInt();
		if (num % 2 == 0)
			for (int i = 0; i < 100; i++) {
				System.out.println(i);
			}
		else
			System.out.println("deu ruim");
	}
}
