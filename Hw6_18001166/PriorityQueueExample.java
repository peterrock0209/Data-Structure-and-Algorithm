package Hw6_18001166;

import Hw6_18001166.SortedArrayPriorityQueue.ArrEntry;


public class PriorityQueueExample {
	
	public static void UnsortedArrayPriorityQueue(){
		UnsortedArrayPriorityQueue pq = new UnsortedArrayPriorityQueue();
		UnsortedArrayPriorityQueue.ArrEntry value;
		value = new UnsortedArrayPriorityQueue.ArrEntry(2, "am");
		pq.insert(value);
		value = new UnsortedArrayPriorityQueue.ArrEntry(5, "I");
		pq.insert(value);
		value = new UnsortedArrayPriorityQueue.ArrEntry(7, "a");
		pq.insert(value);
		value = new UnsortedArrayPriorityQueue.ArrEntry(8, "scientist!");
		pq.insert(value);
		
		pq.insert(1, "I");
		pq.insert(3, "Peter");
		pq.insert(4, "Rock");
		pq.insert(6, "am");
		pq.print();
		
		while(!pq.isEmpty()) {
	        System.out.println("----------------------------------");
	        System.out.println("*Minimum has: " + pq.min());
	        System.out.println("*Remove min!");
	        System.out.println("----------------------------------");
	        pq.removeMin();
	        pq.print();
        }
        if(pq.isEmpty()) {
        	System.out.println("Priority queue is empty, don't remove :>>");
        }
	}
	
	public static void UnsortedLinkedPriorityQueue() {
		UnsortedLinkedPriorityQueue pq = new UnsortedLinkedPriorityQueue();
		pq.insert(4, "A");
		pq.insert(1, "B");
		pq.insert(2, "C");
		pq.insert(3, "D");
		pq.insert(5, "E");
		
		System.out.println("Head: " + pq.head.toString());
        System.out.println("Tail: " + pq.tail.toString());
		System.out.println("*Minimum has: " + pq.min());
		System.out.println("Size: " + pq.size());
		System.out.println();
		
		while(!pq.isEmpty()) {
			pq.removeMin();
			System.out.println("Head: " + pq.head);
			System.out.println("Tail: " + pq.tail);
			System.out.println("*Minimum has: " + pq.min());
			System.out.println("*Remove min!");
	        System.out.println("----------------------------------");
		} 
		if(pq.isEmpty()) {
        	System.out.println("Priority queue is empty, don't remove :>>");
        }
	}
	
	public static void SortedArrayPriorityQueue(){

		SortedArrayPriorityQueue pq = new SortedArrayPriorityQueue();
		ArrEntry value;
		value = new SortedArrayPriorityQueue.ArrEntry(2, "am");
		pq.insert(value);
		value = new SortedArrayPriorityQueue.ArrEntry(5, "I");
		pq.insert(value);
		value = new SortedArrayPriorityQueue.ArrEntry(7, "a");
		pq.insert(value);
		value = new SortedArrayPriorityQueue.ArrEntry(8, "scientist!");
		pq.insert(value);
		
		pq.insert(1, "I");
		pq.insert(3, "Peter");
		pq.insert(4, "Rock");
		pq.insert(6, "am");
		pq.sort();
		pq.print();

		System.out.println("-> Size = " + pq.size());
		
		while(!pq.isEmpty()) {
	        System.out.println("----------------------------------");
	        System.out.println("*Minimum has: " + pq.min());
	        System.out.println("*Remove min!");
	        System.out.println("----------------------------------");
	        pq.removeMin();
	        pq.print();
        }
        if(pq.isEmpty()) {
        	System.out.println("Priority queue is empty, don't remove :>>");
        }
	}
	
	public static void SortedLinkedPriorityQueue() {
		SortedLinkedPriorityQueue pq = new SortedLinkedPriorityQueue();
		pq.insert(4, "A");
		pq.insert(1, "B");
		pq.insert(2, "C");
		pq.insert(3, "D");
		pq.insert(5, "E");
		
		System.out.println("Head: " + pq.head.toString());
        System.out.println("Tail: " + pq.tail.toString());
		System.out.println("*Minimum has: " + pq.min());
		System.out.println("Size: " + pq.size());
		System.out.println();
		
		while(!pq.isEmpty()) {
			pq.removeMin();
			System.out.println("Head: " + pq.head);
			System.out.println("Tail: " + pq.tail);
			System.out.println("*Minimum has: " + pq.min());
			System.out.println("*Remove min!");
	        System.out.println("----------------------------------");
		} 
		if(pq.isEmpty()) {
        	System.out.println("Priority queue is empty, don't remove :>>");
        }
	}
	// main function
	public static void main(String [] args) {
		
		System.out.println("1. This is UnsortedArrayPriorityQueue ");
		UnsortedArrayPriorityQueue();
		System.out.println();
		System.out.println("*************************************");
		
		System.out.println("2. This is SortedArrayPriorityQueue ");
		SortedArrayPriorityQueue();
		System.out.println();
		System.out.println("*************************************");
		
		System.out.println("3. This is UnsortedLinkedPriorityQueue ");
		UnsortedLinkedPriorityQueue();
		System.out.println();
		System.out.println("*************************************");
		
		System.out.println("4. This is SortedLinkedPriorityQueue ");
		SortedLinkedPriorityQueue();
	}

}

