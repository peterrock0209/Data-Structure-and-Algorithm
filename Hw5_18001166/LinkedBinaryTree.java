/* This is exercise 1.2
 * Binary Tree using linked list*/

package Hw5_18001166;

import java.io.FileWriter;
import java.io.IOException;

public class LinkedBinaryTree<E,T> implements BinaryTreeInterface<T> {
	private String fileoutput = "";
	protected static class Node<E> {
		private E element; // an element stored at this node
		private Node<E> parent; // a reference to the parent node (if any)
		private Node<E> left; // a reference to the left child 
		private Node<E> right; // a reference to the right child
		
		public E getElement() {
			return element;
		}
		public void setElement(E e) {
			this.element = e;
		}
		public Node<E> getParent() {
			return parent;
		}
		public void setParent(Node<E> above) {
			this.parent = above;
		}
		public Node<E> getLeft() {
			return left;
		}
		public void setLeft(Node<E> leftChild) {
			this.left = leftChild;
		}
		public Node<E> getRight() {
			return right;
		}
		public void setRight(Node<E> rightChild) {
			this.right = rightChild;
		}
		
		// Constructs a node with the given element and neighbors.
		public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild){
			element = e;
			parent = above;
			left = leftChild;
			right = rightChild;
		} 
	}
	
	// Create a new Node
	public Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
		return new Node<E>(e, parent, left, right);
	}
	
	protected Node<E> root = null;
	private int size = 0;
	
	// Add element to root of an empty tree
	public Node<E> addRoot(E element) throws IllegalStateException{
		if(!isEmpty()) throw new IllegalStateException("Tree is not empty!");
		root = createNode(element, null, null, null);
		
		size ++;
		return root;
	}
	
	// Add element to left child node of p if empty
	public Node<E> addLeft(Node<E> p, E element) throws IllegalStateException{
		if(size == 0 || p == null) return null;
		if(p.getLeft() != null) {
			System.out.println("-> Parent already has a left child is "+p.getLeft());
			
			set(p.getLeft(), element);
		}else {
			Node<E> child = createNode(element, p, null, null);
			p.setLeft(child);			
			size ++;
			//return child;
		}
		return p.getLeft();
	}
	
	// Add element to right child node of p if empty
	public Node<E> addRight(Node<E> p, E element) throws IllegalStateException{
		if(size == 0 || p == null) return null;
		if(p.getRight() != null) {
			System.out.println("-> Parent already has a right child is "+p.getRight());	
			set(p.getRight(), element);
		}else {
			Node<E> child = createNode(element, p, null, null);
			p.setRight(child);
			size ++;
			//return child;
		}
		return p.getRight();
	}
	
	// Set element to node p
	public void set(Node<E> p, E element) throws IllegalStateException {
		if(size == 0 || p == null) return;
		p.setElement(element);
	}
	
	// Print nodes of binary tree
	public void print(Node p, int lv) {
		if(p == null) return;
		print(p.getRight(), lv + 1);
		for (int i = 0; i < lv; i++) {
			System.out.print("\t");
		}
		System.out.println(p.getElement());
		print(p.getLeft(), lv + 1);
	}
	
	// Print to file using file writer
	public void printText(Node p, int lv) {
		if(p == null) return;
		printText(p.getRight(), lv + 1);
		for (int i = 0; i < lv; i++) {
			fileoutput += "\t";
		}
		fileoutput += p.getElement() +"\n";
		printText(p.getLeft(), lv + 1);
	}
	
	public void printFile() throws IOException {
		fileoutput = "";
		printText(root, 0);
		FileWriter myWriter = new FileWriter("/C:/output.txt/");
		myWriter.write("This is a binary tree printed using LinkedBinaryTree " + "\n");
        myWriter.write(fileoutput);
        myWriter.close();	
        }
	
	// Print tree using "in order" method
	public void traverseInOrder(Node<E> p) {
        if (p != null) {
            traverseInOrder(p.left);
            System.out.print(" " + p.element);
            traverseInOrder(p.right);
        }
        else {
        	return;
        }
    }
	
	@Override
	public T root() {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		return (T) root.element;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return root == null;
	}
	
	@Override
	public int numChildren(T p) {
		// TODO Auto-generated method stub
		if(!(p instanceof Node)) return -1;
		Node k = (Node) p ;
		if(isEmpty()) return -1;
		if(k == null) return -1;
		
		int count=0;
		if (k.getLeft() != null) count++;
		if (k.getRight() != null) count++;
		return count;
	}
	
	@Override
	public T parent(T p) {
		// TODO Auto-generated method stub
		if(!(p instanceof Node)) return null;
		Node k = (Node) p ;
		if(isEmpty()) return null;
		if(k == null) return null;
		return (T) k.getParent();
		
	}
	
	@Override
	public T left(T p) {
		// TODO Auto-generated method stub
		if(!(p instanceof Node)) return null;
		Node k = (Node) p ;
		if(isEmpty()) return null;
		if(k == null) return null;
		return (T) k.getLeft();
	}
	
	@Override
	public T right(T p) {
		// TODO Auto-generated method stub
		if(!(p instanceof Node)) return null;
		Node k = (Node) p ;
		if(isEmpty()) return null;
		if(k == null) return null;
		return (T) k.getRight();
	}
	
	@Override
	public T sibling(T p) {
		// TODO Auto-generated method stub
		if(!(p instanceof Node)) return null;
		Node k =	 (Node) p ;
		if(isEmpty()) return null;
		if(k == null) return null;
		
		if(k == k.getParent().getLeft()) return (T) k.getParent().getRight();
		else return (T) k.getParent().getLeft();
	}

}
