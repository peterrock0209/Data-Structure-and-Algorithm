/* This is test function exercise 1.1
 * Binary Tree using array
 * and print binary tree in exercise 1.3*/

package Hw5_18001166;

import java.io.IOException;

public class ArrayBinaryTreeExample {
	
	public static void main(String []args) throws IOException {
		ArrayBinaryTree<String, Integer> planet = new ArrayBinaryTree<String, Integer>();

		planet.setRoot("1");
		planet.setLeft(1, "5");
		planet.setRight(1, "3");
		planet.setLeft(2, "8");
		planet.setRight(2, "6");
		planet.setLeft(3, "2");
		planet.setRight(3, "7");
		
		System.out.print("Tree has: ");
		planet.printTree();
		System.out.println("\n");
		planet.print(1, 0);	
		
		
		// This is the program for lesson 1.3 
		// Export results to file binarytree.txt in ArrayBinaryTree

		planet.printFile();
		
		}
}
