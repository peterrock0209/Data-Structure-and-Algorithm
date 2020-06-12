package Hw7_18001166;

import Hw7_18001166.BinarySearchTree.Node;

public class BinarySearchTreeExample {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree<Integer,Node> bst = new BinarySearchTree<>();
		Node<Integer> root = bst.addRoot(7);
		bst.insert(9);
		bst.insert(5);
		bst.insert(2);
		bst.insert(8);
		bst.insert(6);
		bst.insert(11);
		bst.insert(1);
		System.out.println("Binary Search Tree");
		bst.print(root, 0);
		System.out.println();
		
		bst.delete(6);
		System.out.println("Binary Search Tree");
		bst.print(root, 0);
	}
}
