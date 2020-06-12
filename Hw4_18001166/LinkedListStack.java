package Hw4_18001166;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> { 

	class Node {  	
		E element; 
 		Node next; 
 		} 
 
 	Node stack = null; 
 	
 	public LinkedListStack() {
		// TODO Auto-generated constructor stub
 		this.stack = null;
	}
 	@Override 
 	//Add an element to stack
 	public void push(E element) {  	 
 		Node e = new Node();
 		if(e == null) {
 			System.out.println("\nHeap Overflow");
 			return;
 		}
 		e.element = element; //set data
 		e.next = stack; //set link
 		stack = e; //update top
 	} 
 
 	@Override  	
 	//Remove an element from stack
	public E pop() { 
 		Node p = stack;
 		if(stack ==null) {
 			System.out.println("\nStack Overflow");
 			return null;
 		}
 		stack = stack.next;
 		return p.element;
 	}
 
 	@Override 
 	//Check empty
 	public boolean isEmpty() { 
 	 		return stack == null; 
 		} 

 	@Override 
 	//Return top element in a stack
 	public E top() { 
 		if(!isEmpty()) {
 			return stack.element;
 		}else {
 			System.out.println("Stack is empty!");
 	 		return null;
 		}
 	}
	
	//Display
	public void printStack() {
		Iterator<E> iterator = iterator();
	    while (iterator.hasNext()) {
	      E value = iterator.next();
	      System.out.println(value);
	    }
	} 
 
 	@Override 
 	public Iterator<E> iterator() {  	 		
 	 		return new StackIterator(); 
 	} 
 	class StackIterator implements Iterator<E> {  	
		
		private Node currentNode = stack; 

 		@Override 
 		public boolean hasNext() { 
 	 		// TODO Auto-generated method stub 
 	 		return currentNode != null; 
 		} 
  	 	@Override  	 	
		public E next() { 
 	 		// TODO Auto-generated method stub  	 	 	
			E data = currentNode.element;  	 	 					
			currentNode = currentNode.next;  	 	 	
			return data; 
 	 	} 
 	}

} 
