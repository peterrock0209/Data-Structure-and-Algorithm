package Hw4_18001166;

import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {
	
	class Node {
		E element;
		Node next;
	
		//Constructor to create a new linked list node
		public Node(E element) {
			this.element = element;
			this.next = null;
		}
		public void displayNode()
		    {
		        System.out.print(element+"  ");
		    }
	}
	
	private Node front = null, rear = null;
				
	//Display
	public void printStack() {
	
        Node current = front;
        if(current != null) {
	        System.out.print("Current Queue: ");
	        while(current!=null)
	        {
	            current.displayNode();
	            current=current.next;
	        }
        }else 
        {
            System.out.println("Queue is empty!");

        }
        System.out.println();
	}


    
		/*Iterator<E> iterator = iterator();
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
		
		private Node currentNode = front; 

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
 	 	} */

	@Override
	//Add an element into Queue
	public void enqueue(E element) {
		// TODO Auto-generated method stub
		Node value = new Node(element);
		if(this.rear ==null) {
			this.front = this.rear = value;
			return;
		}
		this.rear.next = value;
		this.rear = value;
	}

	@Override
	//Remove an element from Queue
	public E dequeue() {
		// TODO Auto-generated method stub
		if(front == null) {
			return null;
		}
		
		Node value = this.front;
		this.front = this.front.next;
		
		if(this.front == null) this.rear = null;
		return value.element;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return front == null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	 
}
