package Hw7_18001166;

public class BinarySearchTreeSimple {
	public class Node{
		int key;
		Node left, right;
		
		public Node(int data) {
			key = data;
			left = right = null;
		}
	}
	
	Node root;
	
	public BinarySearchTreeSimple() {
		root = null;
	}
	
	// find minimum element of BST
	public int findMin(Node root) {
		int min = root.key;
		if(root.left != null) {
			min = root.left.key;
			root = root.left;
		}
		return min;
	}
	
	// insert a element into BST
	public Node insertRec(Node root, int key) {
		if(root == null) {
			root = new Node(key);
			return root;
		}
		
		if(key < root.key) {
			root.left = insertRec(root.left, key);
		}else if(key > root.key) {
			root.right = insertRec(root.right, key);
		}
		return root;
	}	
	public void insert(int key) {
		root = insertRec(root, key);
	}
	
	// delete a element from BST
	public Node deleteRec(Node root, int key) {
		if(root == null) return root;
		if(key < root.key) root.left = deleteRec(root.left, key);
		else if(key > root.key) root.right = deleteRec(root.right, key);
		
		// key = node.key
		else {
			if(root.left == null) return root.right;
			else if(root.right == null) return root.left;
			
			root.key = findMin(root.right);
			
			root.right = deleteRec(root.right, root.key);
		}
		return root;
	}
	public void delete(int key) {
		root = deleteRec(root, key);
	}
	
	// traversal BST with in order
	public void inorderRec(Node root){ 
        if (root != null){ 
        	inorderRec(root.left); 
            System.out.print(root.key + " "); 
            inorderRec(root.right); 
        } 
	}
	public void inorder() {
		inorderRec(root);
	}
	
	// main function
	public static void main(String [] args) {
		BinarySearchTreeSimple tree =  new BinarySearchTreeSimple();
		tree.insert(2);
		tree.insert(6);
		tree.insert(5);
		tree.insert(4);
		tree.insert(3);
		tree.insert(1);
		
		tree.inorder();
		System.out.println();
		System.out.println("Min: "+ tree.findMin(tree.root));
		
		tree.delete(1);
		tree.inorder();
		System.out.println();
		System.out.println("Min: "+ tree.findMin(tree.root));
	}
}
