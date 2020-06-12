package Hw6_18001166;

public class SortFunctions {

	// Java program for implementation of QuickSort 
	public static class QuickSort 
	{ 
		
		public int partition(int arr[], int low, int high) 
		{ 
			int pivot = arr[high]; 
			int i = (low-1); // index of smaller element 
			for (int j=low; j<high; j++) 
			{ 
				// If current element is smaller than or 
				// equal to pivot 
				if (arr[j] <= pivot) 
				{ 
					i++; 

					// swap arr[i] and arr[j] 
					int temp = arr[i]; 
					arr[i] = arr[j]; 
					arr[j] = temp; 
				} 
			} 

			// swap arr[i+1] and arr[high] (or pivot) 
			int temp = arr[i+1]; 
			arr[i+1] = arr[high]; 
			arr[high] = temp; 

			return i+1; 
		} 


		/* The main function that implements QuickSort() 
		arr[] --> Array to be sorted, 
		low --> Starting index, 
		high --> Ending index */
		public void sort(int arr[], int low, int high) 
		{ 
			if (low < high) 
			{ 
				/* pi is partitioning index, arr[pi] is 
				now at right place */
				int pi = partition(arr, low, high); 

				// Recursively sort elements before 
				// partition and after partition 
				sort(arr, low, pi-1); 
				sort(arr, pi+1, high); 
			} 
		} 

		public void printArray(int arr[]) 
		{ 
			int n = arr.length; 
			for (int i=0; i<n; ++i) 
				System.out.print(arr[i]+" "); 
			System.out.println(); 
		} 
	}
	
	/* Java program for Merge Sort */
	public static class MergeSort 
	{  
		public void merge(int arr[], int l, int m, int r) 
		{ 
			int n1 = m - l + 1; 
			int n2 = r - m; 

			/* Create temp arrays */
			int L[] = new int [n1]; 
			int R[] = new int [n2]; 

			/*Copy data to temp arrays*/
			for (int i=0; i<n1; ++i) 
				L[i] = arr[l + i]; 
			for (int j=0; j<n2; ++j) 
				R[j] = arr[m + 1+ j]; 
			int i = 0, j = 0; 

			int k = l; 
			while (i < n1 && j < n2) 
			{ 
				if (L[i] <= R[j]) 
				{ 
					arr[k] = L[i]; 
					i++; 
				} 
				else
				{ 
					arr[k] = R[j]; 
					j++; 
				} 
				k++; 
			} 

			/* Copy remaining elements of L[] if any */
			while (i < n1) 
			{ 
				arr[k] = L[i]; 
				i++; 
				k++; 
			} 

			/* Copy remaining elements of R[] if any */
			while (j < n2) 
			{ 
				arr[k] = R[j]; 
				j++; 
				k++; 
			} 
		} 
		// merge() 
		public void sort(int arr[], int l, int r) 
		{ 
			if (l < r) 
			{ 
				// Find the middle point 
				int m = (l+r)/2; 

				// Sort first and second halves 
				sort(arr, l, m); 
				sort(arr , m+1, r); 

				// Merge the sorted halves 
				merge(arr, l, m, r); 
			} 
		} 

		public void printArray(int arr[]) 
		{ 
			int n = arr.length; 
			for (int i=0; i<n; ++i) 
				System.out.print(arr[i]+" "); 
			System.out.println(); 
		} 
	} 
	
	// Java program for implementation of Selection Sort
	public static class SelectionSort{
		public void sort(int []arr)
		{
			int n = arr.length;

			// One by one move boundary of unsorted subarray
			for (int i = 0; i < n-1; i++)
			{
				// Find the minimum element in unsorted array
				int min_idx = i;
				for (int j = i+1; j < n; j++)
					if (arr[j] < arr[min_idx])
						min_idx = j;

				// Swap the found minimum element with the first
				// element
				int temp = arr[min_idx];
				arr[min_idx] = arr[i];
				arr[i] = temp;
			}
		}

		// Prints the array
		public void printArray(int arr[])
		{
			int n = arr.length;
			for (int i=0; i<n; ++i)
				System.out.print(arr[i]+" ");
			System.out.println();
		}
	}
	public static class HeapSort{
		 MinHeapPriorityQueue<Comparable, Integer> heap = new MinHeapPriorityQueue<Comparable, Integer>();
		 public void insert(int [] arr) {
			 for (int i = 0; i < arr.length; i++) {
					heap.insert(arr[i], arr[i]);
				 } 
		 }
		public void sort(int []arr) {			 
			 for (int i = 0; i < arr.length; i++) {
				arr[i] = (int) heap.removeMin().getKey();
			 }
		}
		// Prints the array
			public void printArray(int arr[])
			{
				int n = arr.length;
				for (int i=0; i<n; ++i)
					System.out.print(arr[i]+" ");
				System.out.println();
			}
	}
}

