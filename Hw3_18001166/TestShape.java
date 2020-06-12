package Hw3_18001166;

import java.util.ArrayList;
import java.util.Random;

public class TestShape {
	
	ArrayList<Shape> shape;
	public TestShape() {
		super();
		shape = new ArrayList<Shape>();
		shape.add(new Circle(3));
		shape.add(new Rectangle(2,4));
		shape.add(new Sphere(5));
	}
	
	public void addShape(Shape s) {
		shape.add(s);
	}
	
	public void printShape() {
		for(int i = 0; i < shape.size(); i++) {
			System.out.println(shape.get(i).toString());
		}
	}
	/* Main function */
	public static void main (String [] args) {
		Shape shape;
		TestShape test = new TestShape();
		int x, y, r;
		Random random = new Random();
		do {
			x = random.nextInt(10);
			y = random.nextInt(10);
		}while (x < y);
		shape = new Rectangle(x, y);
		test.addShape(shape);
		test.printShape();
	}	
}
