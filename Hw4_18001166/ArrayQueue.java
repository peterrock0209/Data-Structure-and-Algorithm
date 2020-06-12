package Hw4_18001166;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements QueueInterface<E> { 
	
	private E[] queue;  	
	private int n = 0;  	
	private int top = 0;  	
	private int count = 0;  	
	private int default_size = 100; 
	
	// Generate a stack with given size.
    @SuppressWarnings("unchecked")
 	public ArrayQueue(int capacity) { 
	 		n = capacity; 
	 		queue = (E[]) new Object[capacity]; 
	} 
    
 // Generate stack with default size.
    @SuppressWarnings("unchecked")
	public ArrayQueue() { 
 	 		n = default_size; 
 	 		queue = (E[]) new Object[default_size]; 
 	} 
    
  	@Override 
 	public void enqueue(E element) throws IllegalStateException {  	 	
		// TODO Auto-generated method stub 
  		if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");
         else 
         {  		
        	int value = (top + n)% queue.length;
  			queue[value] = element;
  			n ++;
         }
  	} 
  	@Override  	
	public E dequeue() { 
 	 	// TODO Auto-generated method stub 
  		if(isEmpty()) return null;
  		E value = queue[top];
  		queue[top] = null;
  		top = (top + 1)% queue.length;
  		n--;
  		return value;
 	} 
  	@Override 
 	public boolean isEmpty() { 
  		return n == 0; 
 	} 
  	
  	public void outputQueue() {
  		Iterator<E> iterator = iterator();
	    while (iterator.hasNext()) {
	      E val = iterator.next();
	      System.out.print("["+ val +"] ");
	    }
  	}
	    
 	@Override 
 	public Iterator<E> iterator() {  	 	
		// TODO Auto-generated method stub  	 	
		return (Iterator<E>) new ArrayQueueIterator(); 
 		} 
 
 	class ArrayQueueIterator implements Iterator<E> { 
 	 	private int current = top;  	 	
		private int num = 0; 
 	 	@Override 
	 	public boolean hasNext() {  	 	 	
			// TODO Auto-generated method stub  	 	 	
			return num < count; 
		} 
 		@Override  	 	
		public E next() { 
 	 		// TODO Auto-generated method stub 
 	 		E data = queue[(current + num) % n];  	 	
			num++; 
	 		return data; 
		} 
	} 
 } 