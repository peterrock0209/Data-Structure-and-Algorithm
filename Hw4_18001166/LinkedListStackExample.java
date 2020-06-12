package Hw4_18001166;

public class LinkedListStackExample {
	public static void main(String []args) {
		LinkedListStack<Integer> obj = new LinkedListStack<>();
		//insert Stack value
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		
		//print Stack element
		obj.printStack();
		
		//print Top element
		System.out.println("Top element is: "+obj.top());
		
		//remove Stack element
		obj.pop();
		obj.pop();
		obj.printStack();		
		System.out.println("Top element is: "+obj.top());
		obj.pop();
		obj.pop();
		obj.printStack();		
		obj.top();
	}
}
