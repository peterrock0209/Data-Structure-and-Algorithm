package Hw4_18001166;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
 
public class CheckForParentheses {
    private static Scanner sc;


	static class Node {
        Boolean isPositive;
        Integer value;
        ArrayList<Node> list;
 
        public Node(boolean isPositive, Integer value) {
            this.isPositive = isPositive;
            this.value = value;
            this.list = new ArrayList<>();
        }
 
        public int evaluate() {
            int sum = 0;
            for (Node t : list) {
                if (t.isPositive) {
                    sum = sum + t.value;
                } else {
                    sum = sum - t.value;
                }
            }
            return sum;
        }
    }
 
    public static int evaluate(String s) {
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(true, 0));
 
        Boolean isPositive = true;
        StringBuilder sb = null;
 
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Node top = stack.peek();
 
            if (c >= '0' && c <= '9') {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(c);
                if (i == s.length() - 1 || s.charAt(i + 1) < '0' || s.charAt(i + 1) > '9') {
                    top.list.add(new Node(
                        isPositive == null ? true : isPositive,
                        Integer.valueOf(sb.toString())));
                    isPositive = null;
                    sb = null;
                }
            } else if (c == '(') {
                Node t = new Node(isPositive, null);
                isPositive = null;
                top.list.add(t);
                stack.push(t);
            } else if (c == ')') {
                int val = stack.pop().evaluate();
                top = stack.peek();
                top.list.get(top.list.size() - 1).value = val;
            } else if (c == '-' || c == '+' ) {
                if (c == '-') {
                    isPositive = false;
                } else {
                    isPositive = true;
                }
            }
        }
 
        return stack.peek().evaluate();
    }
 
 
    public static void main(String[] args) {
    	System.out.println("Input string: ");
    	sc = new Scanner(System.in);
    	String str = sc.nextLine();
        System.out.println(str+" = "+ evaluate(str));
    }
}
