package excript;

public class formattexto {
public static void main(String[] args) {
	
	int array[] = new int[10];
	for (int b=0;b<9;b++) {
		System.out.printf("%s%10s\n","________ ","________");
		System.out.printf("%s%10s\n", "Indice", "Valores");
		System.out.printf("%s%10s\n","_________ ","______");
		System.out.printf("%5d %7d\n",b,array[b]);
	}
}
}
