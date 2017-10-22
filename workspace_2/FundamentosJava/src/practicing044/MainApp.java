package practicing044;

public class MainApp {

	public static void main(String[] args) {
		
		Shape[] shapes = new Shape[4];
		shapes[0] = new Square(2, 3, 4);
		shapes[1] = new Square(5, 6, 2);
		shapes[2] = new Triangle(7, 5, 5, 7, 3, 3);
		shapes[3] = new Triangle(6, 9, 4, 6, 5, 5);
		
		for(Shape aShape : shapes) {
			System.out.println("Area: " + aShape.getArea());
			System.out.println("Perimetro: " + aShape.getPerimeter() + "\n");
			
			
			
			
		}
		
	}

}
