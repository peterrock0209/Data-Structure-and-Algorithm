package Hw6_18001166;

public class PriorityQueueUsingArraySimple {
	int n;
	
	// as up heap
	public void increase(int arr[], int i, int val) {
		/* First the element is inserted at the last position of the queue */
		arr[i] = val;
		
		/* If the parent node value is less than its value
		 * Swap two nodes
		 * Continue checking at the location of the parent node */
		while (i > 1 && arr[i/2] > arr[i]) {   
			int temp = arr[i/2];
			arr[i/2] = arr[i];
			arr[i] = temp;
			i = i/2;
		}
	}
	
	// insert element to array
	public void insert(int arr[], int val) {
		n = n + 1;
		arr[n] = -1;
		increase(arr, n, val);
	}
	
	public int size() {
		return n;
	}
	
	// minimal heap using recursive algorithm
	// as down heap
	public void minHeap(int arr [], int i, int n) {
		int min = i;
		int left = 2*i;
		int right = 2*i + 1;
		if ((left <= n) && (left > 0)) {
		      if (arr[left] < arr[min]) {
		    	  min = left;
		      }
		}

	    if ((right <= n && (right > 0))) {
	        if (arr[right] < arr[min]) {
	        	min = right;
	        }
	    }
	    
		if(min != i) {
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
			minHeap(arr, min, n);
		}
	}
	
	// build minimal heap using recursive algorithm
	public void buildMinHeap(int arr[]) {
		for (int i = n/2; i>= 1; i--) {
			minHeap(arr, i, n);
		}
	}
	
	// remove minimal element using minHeap
	public int removeMin(int arr[]) {
		if(n == 0) {
			System.out.println("Can't remove :>>");
			return -1;
		}
		int min = arr[1];
		arr[1] = arr[n];
		n = n-1;
		minHeap(arr, 1, n); 
		return min;	
	}
	
	public void heap_sort(int arr[]){
	    int heap_size = n;
	    buildMinHeap(arr);
	    for(int i = n; i>= 2 ; i-- )
	    {
	    	int temp = arr[1];
			arr[1] = arr[i];
			arr[i] = temp;
	        heap_size = heap_size-1;
	        minHeap(arr, 1, heap_size);
	    }
	}
	
	public void print(int arr[]) {
		for (int i = 1; i <= n; i++) {
			System.out.print(arr[i]+ " ");
		}
	}
	
	public static void main(String [] args) {
		PriorityQueueUsingArraySimple pq = new PriorityQueueUsingArraySimple();
		int arr[] = new int [10];
		pq.insert(arr, 44);
		pq.insert(arr, 55);
		pq.insert(arr, 11);
		pq.insert(arr, 66);
		pq.insert(arr, 77);
		pq.insert(arr, 33);
		pq.insert(arr, 22);
		pq.insert(arr, 88);

		
		pq.print(arr);

		
		System.out.println();
		System.out.println("Size: "+ pq.size());
		
		pq.buildMinHeap(arr);
		pq.print(arr);
		System.out.println();
		
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.println(pq.removeMin(arr));
			pq.print(arr);
			System.out.println();
		}
			
//		System.out.println(pq.removeMin(arr));
//		pq.print(arr);
//		System.out.println();
//		
//		System.out.println(pq.removeMin(arr));
//		pq.print(arr);
//		System.out.println();
//		
//		System.out.println(pq.removeMin(arr));
//		pq.print(arr);
//		System.out.println();
//		
//		System.out.println(pq.removeMin(arr));
//		pq.print(arr);
//		System.out.println();
//		
//		System.out.println(pq.removeMin(arr));
//		pq.print(arr);
//		System.out.println();
//
//		System.out.println(pq.removeMin(arr));
//		pq.print(arr);
//		System.out.println();
//
//		pq.removeMin(arr);		
//		pq.print(arr);
//		System.out.println();
//		
//		pq.removeMin(arr);
//		pq.print(arr);
//		System.out.println();
	
	}
}
