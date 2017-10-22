package practicing044;

public abstract class Person {

	private String name;

	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
//		new Person("Seu Madruga"); // Nao posso instanciar pois ela é uma Classe Abstrata.
		
	}
	
}
