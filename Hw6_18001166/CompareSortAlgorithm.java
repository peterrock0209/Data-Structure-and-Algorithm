package Hw6_18001166;

import Hw6_18001166.SortFunctions.HeapSort;
import Hw6_18001166.SortFunctions.MergeSort;
import Hw6_18001166.SortFunctions.QuickSort;
import Hw6_18001166.SortFunctions.SelectionSort;

public class CompareSortAlgorithm {

	public static void main(String args[]) { 
		int arr[] = new int[10000]; 
		int n = arr.length; 
		for (int i = 0; i < n; i++) {
			arr[i] = i;
		}
			
		HeapSort hs = new HeapSort();
		hs.insert(arr);
		System.out.print("1. Heap Sort: ");
	    long start = System.currentTimeMillis();
	    hs.sort(arr);
	    long end = System.currentTimeMillis();
	    System.out.println();
		System.out.println("-> time: " + (end - start));

		long start1 = System.currentTimeMillis();
		QuickSort qs = new QuickSort(); 
		qs.sort(arr, 0, n-1); 
		System.out.print("2. QuickSort: "); 
//		qs.printArray(arr); 
		long end1 = System.currentTimeMillis();
		System.out.println("-> time: " + (end1 - start1));
		
		long start2 = System.currentTimeMillis();
		MergeSort ms = new MergeSort(); 
		ms.sort(arr, 0, n-1); 
		System.out.print("3. Merge Sort: "); 
//		ms.printArray(arr); 
		long end2 = System.currentTimeMillis();
		System.out.println("-> time: " + (end2 - start2));
		
		long start3 = System.currentTimeMillis();
		SelectionSort ss = new SelectionSort();
		ss.sort(arr);
		System.out.print("4. SelectionSort: "); 
//		ss.printArray(arr); 
		long end3 = System.currentTimeMillis();
		System.out.println("-> time: " + (end3 - start3));
		
	} 
}
