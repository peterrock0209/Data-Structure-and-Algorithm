package Hw4_18001166;
import java.util.Scanner;
public class Bai3 {
	public static boolean IsPair(char x1, char x2) {
		if(x1 =='(' && x2 == ')') {
			return true;
		}
		else if(x1=='{' && x2== '}'){
			return true;
		}else if(x1=='[' && x2==']') {
			return true;
			
		}
		return false;
		
	}
	public static boolean  IsTrueBracket(char[] example) {
		LinkedListStack<Character> a= new LinkedListStack<Character>();
		for(int i=0;i<example.length;i++) {
			if(example[i]=='('|| example[i]=='{'|| example[i]=='[') {
				a.push(example[i]);
			}
			if(example[i]==')'|| example[i]=='}'|| example[i]==']') {
				if(a.isEmpty()) {
					return false;
				}
				else if(! IsPair(a.pop(),example[i])) {
					return false;
				}
			}
		}
		if(a.isEmpty()) {
			return true;
		}
		return false;
	}
	public static void main(String [] args) {
		System.out.println("...");
		Scanner sc= new Scanner(System.in);
		String check= sc.next();
		char [] example = new char[check.length()];		
		for( int i=0;i<check.length();i++) {
			example[i]=check.charAt(i);
		}
		if(IsTrueBracket(example)) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
	}
	
	
	

}
