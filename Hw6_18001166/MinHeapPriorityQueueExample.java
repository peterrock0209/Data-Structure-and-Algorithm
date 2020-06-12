package Hw6_18001166;

public class MinHeapPriorityQueueExample {
	   public static void main(String[] args) {
	        MinHeapPriorityQueue pq = new MinHeapPriorityQueue<>();

		        pq.insert(1, 1);
		        pq.insert(5, 2);
		        pq.insert(9, 3);
		        pq.insert(2, 4);
		        pq.insert(11, 5);
		        pq.insert(4, 6);
		        pq.insert(20, 7);
		        pq.insert(6, 8);		        
		        
		        System.out.println("*Min Heap Priority Queue");
		        pq.print(0, 0);
		        pq.removeMin();
		        System.out.println();
		        System.out.println("*After remove minimum element");
		        pq.print(0, 0);
		                
	    }
}
