package practicing053;

public class Varargs {

	public static void main(String[] args) {
		System.out.println(average(1, 2));
		System.out.println(average(1, 2, 3));
		System.out.println(average(1, 2, 3, 4));
		System.out.println(average(1, 2, 3, 4, 5));
		
	}
	
	public static int average(int a, int b, int... others){
		int result = a + b;
		for (int other : others){
			result += other;
		}
		int average = result / (2 + others.length);
		return average;
	}
	
	
	
}
