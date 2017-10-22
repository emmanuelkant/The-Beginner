package practicing044;

public class Triangle extends Shape {

	private int baseLength;
	private int height;
	private int side1Length;
	private int side2Length;
	private static final int SIDES = 3;

	public Triangle(int x, int y, int baseLength, int height, int side1Length, int side2Length) {
		super(x, y);
		this.baseLength = baseLength;
		this.height = height;
		this.side1Length = side1Length;
		this.side2Length = side2Length;
	}

	@Override
	public float getArea() {
		return (this.baseLength * this.height) / 2;
	}

	@Override
	public int getPerimeter() {
		return (this.baseLength * this.height) / 2;
	}

}
