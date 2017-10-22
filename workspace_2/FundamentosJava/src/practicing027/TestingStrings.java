package practicing027;

public class TestingStrings {
	
	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();
		toStringBf(sb);
		//---------Teste 1
		sb.append("Emmanuel");
		toStringBf(sb);
		//---------Teste 2
		sb.append(" Kant Focat Duarte");
		toStringBf(sb);;
		//---------Teste 3
		sb.delete(14,20);
		toStringBf(sb);
		//---------Teste 4
		char c = sb.charAt(0);
		System.out.println(c);
		//---------Teste 5
		int i = sb.length();
		System.out.println(i);
		//---------Teste 6
		int o = sb.indexOf("D");
		System.out.println(o);
		//---------Teste 7
		int u = sb.lastIndexOf("e");
		System.out.println(u);
		//---------Teste 8
		String h = sb.substring(0, 10);
		System.out.println(h);
		//---------Teste 9
		String t = sb.substring(5);
		System.out.println(t);
		
		
	}
	
	private static void toStringBf(StringBuffer string){
		System.out.println(string);
	}
	
	

}
