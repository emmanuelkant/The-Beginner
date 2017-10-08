package excript;

import java.util.Scanner;

public class ternario {
public static void main(String[] args) {
	Scanner s = new Scanner (System.in);
	
	int dia=0;
	String valor;
	
	System.out.println("Digite o dia da semana");
	dia = s.nextInt();
	
	
	valor = (dia==1) ? "segunda" :
		    (dia==2) ? "terça" :
			(dia==3) ? "quarta" :
			(dia==4) ? "quinta" :
			(dia==5) ? "sexta" :
			(dia==6) ? "sabado" :
			(dia==7) ? "domingo" :
				          "";
	System.out.println(valor);

s.close();
  }
}
