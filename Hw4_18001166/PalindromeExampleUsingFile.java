package Hw4_18001166;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PalindromeExampleUsingFile {

	private static String str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = null;

        try {   
            br = new BufferedReader(new FileReader("C:\\test.txt"));       

            System.out.println("String to check: ");
            String value;

            while ((value = br.readLine()) != null) {
                System.out.println(value);
                value = br.readLine();
            }
            
	        
            
            str = value;
            System.out.println("Current String: "+str);

	        LinkedListQueue<Character> queue = new LinkedListQueue<Character>();
	        LinkedListStack<Character> stack = new LinkedListStack<Character>();
	
	        //Add elements to Queue
	        for(int i=0; i<= str.length()-1; i++) {
	        	queue.enqueue(str.charAt(i));
	        }
	        
	        //Add elements to Stack
	        for(int i=0; i< str.length(); i++) {
	        	stack.push(str.charAt(i));
	        }
	        
	        //Check string
	        if(queue.dequeue().equals(stack.pop())) {
	            System.out.println("- Is Palindrome :>>");
	        }else {
	            System.out.println("- Not Palindrome :<<");
		        }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        
        }
        
	}

