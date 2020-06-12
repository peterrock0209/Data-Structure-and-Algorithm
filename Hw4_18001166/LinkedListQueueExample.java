package Hw4_18001166;

import java.util.Scanner;

public class LinkedListQueueExample {
	private static Scanner sc;

	public static void main(String []args) {
		sc = new Scanner(System.in);
		LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();
		System.out.println("Add elements into Queue: ");
		queue.enqueue(sc.nextInt());
		queue.enqueue(sc.nextInt());
		queue.enqueue(sc.nextInt());
		queue.printStack();
		
		System.out.println("Remove "+queue.dequeue());
		System.out.println("Remove "+queue.dequeue());
		System.out.println("Remove "+queue.dequeue());

		queue.printStack();
	}
}
