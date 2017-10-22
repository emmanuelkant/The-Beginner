package practicing041;

public class C1 {

	private int test;
	
	// Tenho que instanciar a classe para poder usar esse m�todo.
	public int soma1(int a, int b) {
		return a + b;
	}
	
	// Posso acessar com o FQN (Full Qualified Name)
	public static int soma2(int a, int b) {
//		System.out.println(test); //N�o posso acessar atributos e nem m�todos por m�todos estaticos.
//		soma1(1, 3);
		return a + b;
	}
	
	public static void main(String[] args) {
		new C1().soma1(1, 3);
		
		C1.soma2(1, 3);
		
	}
	
	
	
}
