/* This is exercise 2.1
 * Binary Tree with Expression*/

package Hw5_18001166;

public class ExpressionTree<E, T> extends LinkedBinaryTree<E, Node> {
	
	private String string = "";
	public void preorderPrint(Node<E> p) {
		//pre-order traversal of tree with root p
		if (p != null) {
			System.out.print(" " + p.getElement());
			preorderPrint(p.getLeft());
			preorderPrint(p.getRight());
		}
            
	}
	
	public void postorderPrint(Node<E> p) {
		//post-order traversal of tree with root p
		if( p != null) {
			inorderPrint(p.getLeft());
			inorderPrint(p.getRight());
			System.out.print(" " + p.getElement());
		}
	}
	
	public void inorderPrint(Node<E> p) {
		//in-order traversal of tree with root p
		if( p != null) {
			inorderPrint(p.getLeft());
			System.out.print(" " + p.getElement());
			inorderPrint(p.getRight());
		}
	} 
}