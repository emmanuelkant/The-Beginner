package practicing028;

public class BuildAString {

	public static void main(String[] args){
		
		// Maneira Impl�cita.
		String s1 = "Java";
		// Maneira Expl�cita.
		String s2 = new String("Java");
		
		// Atrav�s de um array de chars.
		char[] arrayOfChars = {'J', 'a', 'v', 'a'};
		String fromArray = new String(arrayOfChars);
		
		// Atrav�s do objeto do StringBuilder.
		StringBuilder sb1 = new StringBuilder("Java");
		String fromBuilder = new String(sb1);
		
		// Atrav�s do objeto do StringBuffer.
		StringBuffer sb2 = new StringBuffer("Java");
		String fromBuffer = new String(sb2);
		
		String nulled = null;
		System.out.println("Valor de String �: " + nulled);
		
	}
	
}
