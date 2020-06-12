package Hw7_18001166;

import java.util.Iterator;

public class BSTArrayExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTArray<Integer> list=new BSTArray<Integer>();
		list.add(4);
		list.add(6);
		list.add(1);
		list.add(2);
		list.add(5);
		list.add(3);
		list.add(7);
		
		System.out.println("Size "+list.size());
		Iterator<Integer> it = list.iterator();
		while(it.hasNext())
			System.out.print(it.next()+" ");
		System.out.println();		
		list.isContain(7);
		System.out.println();
		
		list.remove(2);
		System.out.println("Size "+list.size());
		Iterator<Integer> it1 = list.iterator();
		while(it1.hasNext())
			System.out.print(it1.next()+" ");
		System.out.println();	
		list.isContain(7);
	}
}
