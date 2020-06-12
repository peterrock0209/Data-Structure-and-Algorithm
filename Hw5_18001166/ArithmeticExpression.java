package Hw5_18001166;

// Java program for different tree traversals 

/* Class containing left and right child of current 
node and key value*/
class Node 
{ 
	String key; 
	Node left, right; 

	public Node(String string) 
	{ 
		key = string; 
		left = right = null; 
	} 
} 

public class ArithmeticExpression 
{ 
	// Root of Binary Tree 
	Node root; 

	ArithmeticExpression() 
	{ 
		root = null; 
	} 

	/* Given a binary tree, print its nodes according to the 
	"bottom-up" post order traversal. */
	void printPostorder(Node node) 
	{ 
		if (node == null) 
			return; 

		// first recur on left subtree 
		printPostorder(node.left); 

		// then recur on right subtree 
		printPostorder(node.right); 

		// now deal with the node 
		System.out.print(node.key + " "); 
	} 

	/* Given a binary tree, print its nodes in in order*/
	void printInorder(Node node) 
	{ 
		if (node == null) 
			return; 

		/* first recur on left child */
		printInorder(node.left); 

		/* then print the data of node */
		System.out.print(node.key + " "); 

		/* now recur on right child */
		printInorder(node.right); 
	} 

	/* Given a binary tree, print its nodes in pre order*/
	void printPreorder(Node node) 
	{ 
		if (node == null) 
			return; 

		/* first print data of node */
		System.out.print(node.key + " "); 

		/* then recur on left subtree */
		printPreorder(node.left); 

		/* now recur on right subtree */
		printPreorder(node.right); 
	} 

	// Wrappers over above recursive functions 
	void printPostorder() {	 printPostorder(root); } 
	void printInorder() {	 printInorder(root); } 
	void printPreorder() {	 printPreorder(root); } 

	// Driver method 
	
 
	public static void main(String[] args) 
	{ 
		System.out.println("ArithmeticExpression!");
		ArithmeticExpression tree = new ArithmeticExpression(); 
		tree.root = new Node("+"); 
		tree.root.left = new Node("-"); 
		tree.root.right = new Node("1"); 
		tree.root.left.left = new Node("2"); 
		tree.root.left.right = new Node("3"); 
	
		System.out.print("-> Prefix expression is: ");
		tree.printPreorder(); 
		System.out.println();
	
		System.out.print("-> Infix expression is: "); 
		tree.printInorder(); 
		System.out.println();
	
		System.out.print("-> Postfix expression is: ");
		tree.printPostorder(); 
	} }
