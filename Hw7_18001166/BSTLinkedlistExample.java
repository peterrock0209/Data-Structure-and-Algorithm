package Hw7_18001166;

public class BSTLinkedlistExample {
	public static void main(String [] args) {
		BSTLinkedList<Integer> list = new BSTLinkedList<Integer>();
		list.add(4);
		list.add(6);
		list.add(1);
		list.add(2);
		list.add(5);
		list.add(3);
		list.add(7);
		
		System.out.println("Size "+list.size());
		for(int i = 0;i < list.size();i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		list.isContain(6);
		list.isContain(3);
		System.out.println();
		
		list.remove(5);
		
		System.out.println("Size "+list.size());
		for(int i = 0;i < list.size();i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		list.isContain(6);
		list.isContain(3);
	}
}
