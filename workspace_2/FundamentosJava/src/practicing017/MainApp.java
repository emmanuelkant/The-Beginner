package practicing017;

public class MainApp {

	public static void main(String[] args) {
		Vendedor salesman = new Vendedor("Emmanuel", 1000f, 200.50f);
		System.out.println(salesman.getSalario());
		System.out.println(salesman.toString());
	}

}
