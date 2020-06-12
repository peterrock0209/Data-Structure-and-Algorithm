package Hw4_18001166;

import java.util.Scanner;

public class ArrayListStackExample {
	private static Scanner sc;

	public static void main(String [] args) {
		sc = new Scanner(System.in);
		ArrayListStack<Integer> arrStack = new ArrayListStack<Integer>();
		System.out.println("Add an element to Stack: ");
		arrStack.push(sc.nextInt());
		arrStack.push(sc.nextInt());
		arrStack.push(sc.nextInt());
		arrStack.push(sc.nextInt());
		
		System.out.print("Stack has: ");
		arrStack.outputStack();
		
		System.out.println("Element deleted: " + arrStack.pop());
		System.out.print("Stack has: ");
		arrStack.outputStack();
		System.out.println("First element is: " + arrStack.top());

	}
}
