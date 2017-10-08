import java.util.Scanner;

public class whilee {
public static void main(String[] args) {
 Scanner s = new Scanner (System.in);
int valor;
	do {
		System.out.println("Digite o valor");
       valor = s.nextInt();
	} while (valor != -1); 
	s.close();
  }
}
