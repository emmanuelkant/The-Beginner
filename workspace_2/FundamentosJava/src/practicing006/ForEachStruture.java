package practicing006;

public class ForEachStruture {

	public static void main(String[] args) {

		float[][] array = new float[4][3];

		array[0][0] = 1.1f;
		array[0][1] = 1.2f;
		array[0][2] = 1.3f;
		array[1][0] = 2.1f;
		array[1][1] = 2.2f;
		array[1][2] = 2.3f;
		array[2][0] = 3.1f;
		array[2][1] = 3.2f;
		array[2][2] = 3.3f;
		array[3][0] = 4.1f;
		array[3][1] = 4.2f;
		array[3][2] = 4.3f;

		for (float[] arrayOfArray : array) {
			for (int i = 0; i < arrayOfArray.length; i++) {
				System.out.print(arrayOfArray[i] + " ");
			}
			System.out.print("\n");
		}
		

	}

}
