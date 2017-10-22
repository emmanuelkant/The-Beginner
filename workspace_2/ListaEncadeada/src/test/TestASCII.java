package test;

public class TestASCII {

	public static void main(String[] args) {

		char[] letters = new char[26];
		char number = 65;
		for (int i = 0; i < letters.length; i++){
			letters[i] = number;
			number++;
		}

		for (char letter : letters)
			System.out.println(letter);

	}

}
