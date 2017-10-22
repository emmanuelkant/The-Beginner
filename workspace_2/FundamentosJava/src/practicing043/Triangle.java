package practicing043;

public class Triangle implements Shape {

	private int baseLength;
	private int height;
	private int side1Length;
	private int side2Length;
	private static final int SIDES = 3;

	public Triangle(int height, int baseLength, int side1Length, int side2Length) {
		this.height = height;
		this.baseLength = baseLength;
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
