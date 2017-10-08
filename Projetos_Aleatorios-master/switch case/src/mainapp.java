import java.util.Scanner;

public class mainapp {
public static void main(String[] args) {
	Scanner s = new Scanner (System.in);
	String tipo;
	int pernas;
	System.out.print("Digite o número de pernas: ");
	pernas = s.nextInt();
	switch (pernas) {
	case 1:
		tipo = "saci";
		break;
	case 2:
		tipo = "Humano";
		break;
	case 3:
		tipo = "quadrúpede amputado";
		break;
	case 4:
		tipo = "Quadrúpede";
		break;
	default:
		tipo = "ET";
	}
		System.out.println(tipo);
		s.close();
	}
	
}

