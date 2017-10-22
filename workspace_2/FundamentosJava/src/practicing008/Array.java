package practicing008;

public class Array {

	public static void main(String[] args) {

		float[] salarios = new float[10];

		salarios[0] = 1547.85f;
		salarios[1] = 5487.24f;
		salarios[2] = 5784.58f;
		salarios[3] = 3548.98f;
		salarios[4] = 5147.58f;
		salarios[5] = 5987.35f;
		salarios[6] = 6588.95f;
		salarios[7] = 8741.65f;
		salarios[8] = 3254.95f;
		salarios[9] = 5478.95f;

		for (int i = 0; i < 10; i++) {
			System.out.println("R$" + salarios[i]);
		}

	}

}
