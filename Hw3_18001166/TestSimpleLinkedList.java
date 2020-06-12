package Hw3_18001166;

import java.util.Random;
import java.util.Scanner;

public class TestSimpleLinkedList {
	public static void main (String [] args) {
		Scanner scan = new Scanner(System.in);
		
		/* Creating object of class simpleLinkedList */
		SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
		System.out.println("Simple Linked List Test\n");
		System.out.println("Enter element to insert at top ");
		list.add(scan.nextInt());
		list.printNode();
		
		System.out.println("Enter n ");
		int n = scan.nextInt();
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			list.add(random.nextInt(100));
		}

		list.printNode();
		System.out.println("Enter elemtnt to remove ");
		list.remove(scan.nextInt());
		list.printNode();

	}
}
