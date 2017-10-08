import java.util.Scanner;

public class relacionais {
	public static void main(String[] args) {
		{
			int n1, n2, r;
			n1 = 5;
			n2 = 10;
			r = (n1 > n2) ? n1 + n2 : n1 - n2;
			System.out.println(r);
		}
		{
			String nome1 = "Danilo";
			String nome2 = "Danilo";;
			String res;
			res = (nome1 == nome2) ? "igual" : "diferente";
			System.out.println(res);
		}

		Scanner s = new Scanner(System.in);
		String nome1, nome2, res;
		System.out.println("Qual o seu nome ? ");
		nome1 = s.next();
		System.out.println("Qual o seu nome ? ");
		nome2 = s.next();
		res = (nome1.equals(nome2)) ? "igual" : "diferente";
		System.out.println(res);
		s.close();
	}
}
