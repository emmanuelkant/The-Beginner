package practicing049;

public class Labeled {

	void testingLabaled() {
		/*
		 * Posso criar labels para refereciar os códigos, caso não tivesse
		 * nomeado o break na linha 16, ele teria quebrado o loop mais proximo
		 * dele.
		 */
		external: for (int i = 0; i < 10; i++) {
			System.out.println(i + "° Vez fora do laco.");
			internal: for (int j = 0; j < 10; j++) {
				System.out.println(j + "° Vez dentro do laco.");
				if (j == 5) {
					System.out.println("Quebrando o laco interno!!!!!!");
					break internal;
				}
				if (i == 8) {
					System.out.println("Quebrando o laco externo!!!!!!");
					break external;
				}
			}
		}
	}

	public static void main(String[] args) {
		new Labeled().testingLabaled();
	}

}
