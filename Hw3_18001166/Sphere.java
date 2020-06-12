package Hw3_18001166;

public class Sphere extends Shape {

	private double radius = 0;
	
	public Sphere(double radius) {
		this.radius = radius;
	}
	
	@Override
	protected double getVolume() {
		return (float)4/3*3.14*(Math.pow(radius, 3));
	}

	@Override
	protected double getArea() {
		return 4*3.14*radius*radius;
	}

	@Override
	protected double getPerimeter() {
		return 0;
	}
   }
