package Hw6_18001166;

public class HeapPriorityQueue {
	public static void heapSort(int arr []) {
		 MinHeapPriorityQueue<Comparable, Integer> heap = new MinHeapPriorityQueue<Comparable, Integer>();
		 for (int i = 0; i < arr.length; i++) {
			heap.insert(arr[i], arr[i]);
		}
		 for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) heap.removeMin().getKey();
			System.out.print(arr[i] + " ");
		}
	}
	
	 public static void main(String[] args) {
//		 MinHeapPriorityQueue pq = new MinHeapPriorityQueue<>();	
		 int arr [] = {10, 7, 8, 9, 1, 5, 6, 7, 8, 4, 6, 11, 20};
	     System.out.print("*Heap Sort: ");
	     heapSort(arr);
	 }
             
}
