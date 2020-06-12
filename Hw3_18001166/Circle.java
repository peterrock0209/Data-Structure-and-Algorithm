package Hw3_18001166;

public class Circle extends Shape {

	private double radius = 0;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	@Override
	protected double getVolume() {
		return 0;
	}

	@Override
	protected double getArea() {
		return 3.14 * radius * radius;		
	}

	@Override
	protected double getPerimeter() {
		return 3.14 * 2 * radius;
	}
  }
