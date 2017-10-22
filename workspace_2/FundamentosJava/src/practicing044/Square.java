package practicing044;

public class Square extends Shape {

	private int sideLength;
	private static final int SIDES = 4;

	public Square(int x, int y, int sideLength) {
		super(x, y);
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
