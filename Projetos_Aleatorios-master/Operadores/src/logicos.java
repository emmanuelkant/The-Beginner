
public class logicos {
	public static void main(String[] args) {
		int x, y, z;
		x = 5;
		y = 7;
		z = 6;
		boolean r;
		r = (x < z && y > z) ? true : false; // os dois tem que ser verdadeiro 
		System.out.println(r);
		
		r = (x < z ^ y > z) ? true : false; // somente um deles
		System.out.println(r);
		
		r = (x < z || y > z) ? true : false; // ou um ou outro
		System.out.println(r);
		
		

	}
}
