package practicing029;

public class Util {

	public static int sum(int a, int b) {
		return a + b;
	}

	public static float sum(float a, float b) {
		return a + b;
	}

	public static float sum(int a, float b) {
		return a + b;
	}

	public static double sum(double a, double b) {
		return a + b;
	}

	public static float sum(float a, int b) {
		return a + b;
	}

	public static void main(String[] args) {
		
		System.out.println(args[0] + " " + args[1]);
		System.out.println("Int + Int: " + Util.sum(2, 2));
		System.out.println("Float + Float: " + Util.sum(2.3f, 4.8f));
		System.out.println("Int + Float: " + Util.sum(12, 8.3f));
		System.out.println("Double + Double: " + Util.sum(2.47, 2.82));
		System.out.println("Float + Int: " + Util.sum(2.74f, 2));

	}

}
