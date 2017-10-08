package vetores;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class mainapp {
	public static void main(String[] args) {
        // TODO code application logic here
        
        // Obtém o Ano Atual do sistema
        Calendar calendario = GregorianCalendar.getInstance(); 
        int ano = calendario.get(Calendar.YEAR);
        
        // Mês e Dias
        String mes[] = {"Jan","Fev","Mar","Abr","Mai","Jun", 
                                  "Jul","Ago","Set","Out","Nov","Dez"};
        int dias[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        
        
        for(int i=0; i<mes.length; i++){
            // Ano bissexto
            if((ano % 4 == 0) && (ano % 100 != 0) || (ano % 400 == 0)){
                dias[1] = 29;
                System.out.println("O mês de " + mes[i] + " tem " + dias[i]);
            }
            // Não é ano bissexto
            else
                System.out.println("O mês de " + mes[i] + " tem " + dias[i]);
        }}}