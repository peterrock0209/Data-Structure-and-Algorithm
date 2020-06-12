package Hw3_18001166;

public class Rectangle extends Shape {

	private double width = 0;
	private double height = 0;
	
	public Rectangle(double width, double height) {
		this.height = height;
		this.width = width;
	}
	
	@Override
	protected double getVolume() {
		return 0;
	}

	@Override
	protected double getArea() {
		return width * height;
	}

	@Override
	protected double getPerimeter() {
		return (width + height) * 2;
	}
}
