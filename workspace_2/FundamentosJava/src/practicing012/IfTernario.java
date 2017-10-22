package practicing012;

public class IfTernario {
	
	public static void main(String[] args) {
		
		int a = 5;
		String s = a > 2 ? "maior" : "menor";
		
		int a2 = 5;
		String s2;
		if (a2 > 2) {
			s2 = "maior";
		} else {
			s2 = "menor";
		}
		
		System.out.println(s);
		System.out.println(s2);
		
		
	}

}
