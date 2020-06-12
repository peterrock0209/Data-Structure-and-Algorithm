/* This is test function exercise 1.2
 * Binary Tree using linked list*/

package Hw5_18001166;

import java.io.IOException;
import java.util.Scanner;
import Hw5_18001166.LinkedBinaryTree.Node;

public class LinkedBinaryTreeExample {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String [] args) throws IOException {
		LinkedBinaryTree<Integer, Integer> LBT = new LinkedBinaryTree<Integer, Integer>();
		Node<Integer> root = LBT.addRoot(1);
				
		Node<Integer> root_left = LBT.addLeft(root, 2);
		Node<Integer> root_left_left = LBT.addLeft(root_left, 4);
		LBT.addRight(root_left, 5);
		LBT.addLeft(root_left_left, 8);
		LBT.addRight(root_left_left, 9);

		Node<Integer> root_right =  LBT.addRight(root, 3);
		Node<Integer> root_right_right = LBT.addRight(root_right, 7);
		LBT.addLeft(root_right, 6);
		LBT.addLeft(root_right_right, 10);
		LBT.addRight(root_right_right, 11);
	
		
		System.out.print("-> Node has: ");
		LBT.traverseInOrder(root);
		
		System.out.println("\n" + "Tree ");
		LBT.print(root, 0);
		System.out.println();
		
		
//		System.out.print("Set element to root: ");
//		LBT.set(root, sc.nextInt());		
//		System.out.println();
//		
//		System.out.print("-> Node has: ");
//		LBT.traverseInOrder(root);
		
		// This is the program for lesson 1.3 
		// Export results to file binarytree.txt in ArrayBinaryTree
		
		LBT.printFile();

	}
}
