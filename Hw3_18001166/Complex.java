package Hw3_18001166;

import java.util.Scanner;

public class Complex {
	private float real;  
	private float image; 
	
	public Complex() {
		
	}
	public Complex(float r, float i) {
		this.real = r;
		this.image = i;
	}
	//Addition
	public Complex add(Complex c) {
		Complex b = new Complex();
        b.real=real+c.real;
        b.image=image+c.image;
        return b;
	}
	//Minus
	public Complex minus(Complex c) {
		Complex b = new Complex();
        b.real=real- c.real;
        b.image=image- c.image;
        return b;
	}
	//Multiple
	public Complex time(Complex c) {
		Complex b= new Complex();
        b.real=real*c.real-image*c.image;
        b.image=real*c.image+image*c.real;
        return b;
	}
	//Scanner
	public float input() {
		Scanner sc = new Scanner(System.in);
		float x = sc.nextFloat();	
		return x;
	}
	//Input
	public Complex inputComplex() {
		System.out.println("- Real: ");
		float a = input();
		System.out.println("- Image: ");
		float b = input();
		Complex C = new Complex(a,b);
		return C;
	}
	//Output
	public void outputComplex(Complex C) {
		System.out.println(C.real+" + "+C.image+"*i");
	}
	
	public float realpart() {
		return real;
	}
	
	public float imagepart() {
		return image;
	}
	
	@Override
	public String toString() {
		if(image ==0) {
        	return real+"";
        }
        if(image > 0)
            return real+"+"+image+"i";
        else
            return real+""+image+"i";
    }
    
}
