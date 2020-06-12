package Hw4_18001166;

import java.util.Scanner;

public class PalindromeExample {


    private static Scanner input;

	public static void main(String[] args) {

        input = new Scanner(System.in);

        System.out.println("Enter the String:: ");
        String str = input.nextLine();

        LinkedListQueue<Character> queue = new LinkedListQueue<Character>();
        LinkedListStack<Character> stack = new LinkedListStack<Character>();


        for(int i=0; i<= str.length()-1; i++) {
        	queue.enqueue(str.charAt(i));
        }

        for(int i=0; i< str.length(); i++) {
        	stack.push(str.charAt(i));
        }

        if(queue.dequeue().equals(stack.pop())) {
            System.out.println("-> Palindrome");
        }else {
            System.out.println("-> Not Palindrome");
        }

    }

}