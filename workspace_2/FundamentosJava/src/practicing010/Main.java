package practicing010;

import practicing009.Cadeira;

public class Main extends Cadeira{

	public static void main(String[] args) {
		
		Cadeira c = new Cadeira();
//		c.setColor("Blue");
//		c.color = "Red";
	}
	
	
	/**
	 * Esse ponto é importantissimo.
	 * 
	 */
	private void m1() {
		this.color = "Red";
		
		Main c = new Main();
//		c.setColor("Blue");
		c.color = "Red";
	}
	
}
