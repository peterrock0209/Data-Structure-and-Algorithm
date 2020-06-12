package Hw7_18001166;

public class BSTLinkedList<T>{
	class Node{
		T data;
		Node next;
		public Node(T data) {
			super();
			this.data = data;
			this.next = null;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		
		public Node getNext() {
			return next;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
	}
	
	private Node top = null;
	private Node bot = null;
	private int n = 0;
	
	public void add(T data) {
		if(top == null) {
			Node a = new Node(data);
			top = bot = a;
			n++;
		} else {
			Node a = new Node(data);
			a.next = top;
			top = a;
			n++;
		}
	}
	
	public T get(int i) {
		if(i > n || i < 0) {
			return null;
		} else {
			Node temp = top;
			for(int j = 0; j < i; j++) {
				temp = temp.next;
			}
		return temp.data;	
		}
	}
	
	public void set(int i, T data) {
		int count = 0;
		Node temp = top;
		while (temp.next != null && count != i) {
			count++;
			temp = temp.next;
		}
		temp.setData(data);
	}
	
	public void isContain(T data) {
		int i = 0;
		if(top == null) {
			System.out.println("empty list");
		}
		Node temp=top;
		while(i < size() && temp.data != data) {
			i++;
			temp=temp.next;
		}
		if(i>size() && bot==null) {
			System.out.println("Not founded!");
		}else {
			System.out.println("Element at index "+ i);
		}
	}
	
	public int size() {
		return n;
	}
	
	public boolean isEmpty() {
		return  n==0;
	}
	
	public T removeTop() {
		if(top == null) {
			return null;
		} else {
			T oldTopData = top.data;
			top = top.next;
			n--;
			return oldTopData;
		}
	}
	
	public void remove(T data) {
		if(top == null) {
			System.out.println("List is Empty");
		} else {
			Node tmp = top;
			while(tmp.data.equals(data)) {
				removeTop();
				tmp = top;
			}
			if(tmp != null) {
				while(tmp.next != null) {
					if(tmp.next.data.equals(data)) {
						if(tmp.next == bot) {
							bot = tmp;
						}
						tmp.next = tmp.next.next;
						n--;
					}else {
						tmp = tmp.next;
					}
				}
			}
		}
	}
}

