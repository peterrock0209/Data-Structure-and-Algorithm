package Hw5_18001166;

import Hw5_18001166.LinkedBinaryTree.Node;

public class ExpressionTreeExample {
	public static void main(String []args) {
		ExpressionTree<String, Integer> et = new ExpressionTree<String, Integer>();
		
		Node<String> root = et.addRoot("+");
			
		Node<String> root_left = et.addLeft(root, "-");
		et.addLeft(root_left, "1");
		et.addRight(root_left, "2");
		
		Node<String> root_right =  et.addRight(root, "*");
		et.addLeft(root_right, "3");
		et.addRight(root_right, "4");
		
		// This is the program to print expressions 2.2
		// include expressions for prefix, infix, and postfix
		
		System.out.print("Prefix expression: ");
		et.preorderPrint(root);
		System.out.println();
		
		System.out.print("Infix expression: ");
		et.inorderPrint(root);
		System.out.println();
		
		System.out.print("Postfix expression: ");
		et.postorderPrint(root);
	}
}
