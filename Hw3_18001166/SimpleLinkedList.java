package Hw3_18001166;

/*
 *  Java Program to Implement Singly Linked List
 */
	public class SimpleLinkedList<T> {
		/*  Class Node  */
		class Node
		{
		    protected T data;
		    protected Node next;
		    
		    /*  Constructor  */
		    public Node(T d,Node n)
		    {
		        data = d;
		        next = n;
		    }    
		    /*  Function to set link to next Node  */
		    public void setNext(Node n)
		    {
		    	next = n;
		    }    
		    /*  Function to set data to current Node  */
		    public void setData(T d)
		    {
		        data = d;
		    }    
		    /*  Function to get link to next node  */
		    public Node getNext()
		    {
		        return next;
		    }    
		    /*  Function to get data from current Node  */
		    public T getData()
		    {
		        return data;
		    }
		}
		
		private Node top = null; //start
		private Node bot = null; //end
		private int n = 0; //size
		
		/*  Constructor  */
	    public void linkedList()
	    {
	        top = null;
	        bot = null;
	        n = 0;
	    }
	    
	    /*  Function to insert an element at begin  */
		public void add(T data) {
			Node value = new Node(data, null);
			n++;
			if(top == null) {
				top = value;
				bot = top;
			}else {
				value.setNext(top);
				top = value;
			}
		}
		
		/*  Function to insert an element at end  */
		public void addBot(T data) {
			Node value = new Node(data, null);
			n++;
			if(top == null) {
				top = value;
				bot = top;
			}else {
				bot.setNext(value);
				bot = value;
			}
			
		}
		
		/*  Get an element at position  */
		public T getElement(int i) {
			int k = 0;
			Node e = top;
			if(top == null || i < 0 || i >= n) {
				return null;
			}
			while(e.next != null && k != i) {
				k++;
				e = e.next;
			}
			return e.data;
		}
		
		/* Set an element = data */
		public void set(int i, T data){
			if(top == null || i < 0 || i >= n) {
				return ;
			}
			
			int k = 0;
			Node last = top;			
			while(last.next != null && k!=i) {
				k++;
				last = last.next;
			}
			last.setData(data);
		}
		
		/* Check if the list contains an elements or not? */
		public boolean isContain(T data) {
			Node p = top;
			while(p != null && !p.data.equals(data) ) {
				p = p.next;
			}
			if(p != null) {
				return true;
			}else return false;
		
		}
		
		/*  Function to get size of list  */
		public int size() {
			return n;	
		}
		
		/*  Function to check if list is empty  */
		public boolean isEmpty() {
		return top == null;	
		}
		
		/* Delete the element at the top of the list */
		public T removeTop() {
			Node p = top;
			top = top.getNext();
            n--; 
            return p.data;
		}
		
		/* Delete the element at the bottom of the list */
		public T removeBot() {
			Node s = top;
			if( n <= 1 ) {
				if(n == 0) {
					return null;
				}
				top = null;
				bot = null;
				n--;
				return s.data;
			}else {

				while(s.getNext() != bot) {			
					s = s.getNext();
				}
				T tmp = bot.getData();
				bot = s;
				bot.setNext(null);
				return tmp;
			}
		}
		/* Delete the element equals data*/
		public void remove(T data) {		
			Node curNode = top;
			while(curNode.getData().equals(data)) {
				removeTop();
				curNode = top;
			}
			if(curNode != null) {
				while(curNode.next != null ){
					if(curNode.next.data.equals(data)) {
						if(curNode.next == bot) {
							bot = curNode;
						}
						curNode.next = curNode.next.next;
						n--;
					}else {					
						curNode = curNode.next;		
					}
				}
			}
		}
		
		/*  Method to print the LinkedList */
		public void printNode() { 
	        Node curNode = top; 
	        System.out.print("Sipmple LinkedList: "); 
	  	        while (curNode != null) { 
	            System.out.print(curNode.data + " "); 
	            // Go to next node 
	            curNode = curNode.next; 
	        } 
	  	        System.out.println();
	    } 
	}
