package Hw4_18001166;

import java.util.Scanner;

public class ArrayQueueExample {
	private static Scanner sc;

	public static void main(String []args) {
		sc = new Scanner(System.in);
		System.out.println("Enter Size of Integer Queue ");
		int n = sc.nextInt();
		ArrayQueue<Integer> arrQ = new ArrayQueue<Integer>(n);
		System.out.println("Add elements: ");
		arrQ.enqueue(sc.nextInt());
		arrQ.enqueue(sc.nextInt());
		arrQ.enqueue(sc.nextInt());
		arrQ.enqueue(sc.nextInt());
		//arrQ.dequeue();
		System.out.println("Queue: ");
		arrQ.outputQueue();
	}
}
