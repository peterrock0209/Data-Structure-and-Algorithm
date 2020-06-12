package Hw5_18001166;


// Java program to construct an expression tree - lesson 3
  
import java.util.Stack;
  
// Java program for expression tree calculate
public class ExpressionTreeToCalculate { 

	static class Node { 
	  
	    char value; 
	    Node left, right; 
	  
	    Node(char data) { 
	        value = data; 
	        left = right = null; 
	    } 
	} 
  
    // The function to check if 'c' 
    // is an operator 
    boolean isOperator(char c) { 
        if (c == '+' || c == '-' || c == '*' || c == '/') { 
            return true; 
        } 
        return false; 
    } 
    
    // The function to do preorder traversal 
    void preorder(Node t) { 
        if (t != null) { 
            System.out.print(t.value + " "); 
        	preorder(t.left); 
            preorder(t.right); 
        } 
    } 
  
    // The function to do inorder traversal 
    void inorder(Node t) { 
        if (t != null) { 
            inorder(t.left); 
            System.out.print(t.value + " "); 
            inorder(t.right); 
        } 
    } 
    
    // The function to do postorder traversal 
    void postorder(Node t) { 
        if (t != null) { 
        	postorder(t.left); 
            postorder(t.right); 
            System.out.print(t.value + " "); 
        } 
    } 
    
    // Returns root of constructed tree for given 
    // postfix expression 
    Node constructTree(char postfix[]) { 
        Stack<Node> st = new Stack<Node>(); 
        Node t, t1, t2; 
  
        // Traverse through every character of 
        // input expression 
        for (int i = 0; i < postfix.length; i++) { 
  
            // If operand, push into stack 
            if (!isOperator(postfix[i])) { 
                t = new Node(postfix[i]); 
                st.push(t); 
            } else 
            { 
                t = new Node(postfix[i]); 
  
                // Pop two top nodes 
                t1 = st.pop();     
                t2 = st.pop(); 
  
                // make them children 
                t.right = t1; 
                t.left = t2; 
  
                // add this subexpression to stack 
                st.push(t); 
            } 
        } 
  
        // only element will be root of expression tree 
        t = st.peek(); 
        st.pop(); 
  
        return t; 
    } 
    
    static int evaluatePostfix(String exp) 
    { 
        Stack<Integer> st = new Stack<>(); 
          
        // Scan all characters one by one 
        for(int i = 0; i < exp.length(); i ++) 
        { 
            char c = exp.charAt(i); 
              
            // If is an operand, push it to the stack. 
            if(Character.isDigit(c)) 
            st.push(c - '0'); 
              
            // If is an operator, pop two elements
            // from stack apply the operator 
            else
            { 
                int val1 = st.pop(); 
                int val2 = st.pop(); 
                  
                switch(c) 
                { 
                    case '+': 
                    st.push(val2 + val1); 
                    break; 
                      
                    case '-': 
                    st.push(val2 - val1); 
                    break; 
                      
                    case '/': 
                    st.push(val2 / val1); 
                    break; 
                      
                    case '*': 
                    st.push(val2 * val1); 
                    break; 
              } 
            } 
        } 
        return st.pop();     
    } 
  
    public static void main(String args[]) { 
  
    	ExpressionTreeToCalculate et = new ExpressionTreeToCalculate(); 
        String postfix = "123*+456+*+"; 
        char[] charArray = postfix.toCharArray(); 
        Node root = et.constructTree(charArray); 
        
        System.out.print("-> Prefix expression: ");
        et.preorder(root);
        System.out.println();
        
        System.out.print("-> Infix expression: "); 
        et.inorder(root); 
        System.out.println();
       
        System.out.print("-> Postfix expression: ");
        et.postorder(root);
        System.out.println();
        
        System.out.println("Calculate the expression value");
        et.inorder(root); 
        System.out.println("= (1 + (2 * 3)) + (4 * (5 + 6)) = " + ExpressionTreeToCalculate.evaluatePostfix(postfix));
    } 
} 
  
