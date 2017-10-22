package practicing043;

public class Square implements Shape {

	private int sideLength;
	private static final int SIDES = 4;

	public Square(int sideLength) {
		super();
		this.sideLength = sideLength;
	}

	@Override
	public float getArea() {
		return this.sideLength * sideLength;
	}

	@Override
	public int getPerimeter() {
		return this.SIDES * this.sideLength;
	}

}
