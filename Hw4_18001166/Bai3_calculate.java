package Hw4_18001166;

public class Bai3_calculate {
		static Bai3 test = new Bai3();
		public static int evaluate(String expression) 
		{ 
			char[] tokens = expression.toCharArray(); 

			
			LinkedListStack<Integer> values = new  LinkedListStack<Integer>(); 

			 
			LinkedListStack<Character> ops = new LinkedListStack<Character>(); 

			for (int i = 0; i < tokens.length; i++) 
			{ 
				if(tokens[i] == ' ') {
					continue;
				}
				if (tokens[i] >= '0' && tokens[i] <= '9') 
				{ 
					StringBuffer sbuf = new StringBuffer(); 
					while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') 
						sbuf.append(tokens[i++]); 
					values.push(Integer.parseInt(sbuf.toString())); 
				} 

				else if (tokens[i] == '(') 
					ops.push(tokens[i]); 

				
				else if (tokens[i] == ')') 
				{ 
					while (ops.top() != '(') 
					values.push(Operation(ops.pop(), values.pop(), values.pop())); 
					ops.pop(); 
				} 
				else if (tokens[i] == '+' || tokens[i] == '-' || 
						tokens[i] == '*' || tokens[i] == '/') 
				{ 
					while (!ops.isEmpty() && hasPrecedence(tokens[i], ops.top())) 
					values.push(Operation(ops.pop(), values.pop(), values.pop())); 

					 
					ops.push(tokens[i]); 
				} 
			} 

			while (!ops.isEmpty()) 
				values.push(Operation(ops.pop(), values.pop(), values.pop())); 

			return values.pop(); 
		} 
		public static boolean hasPrecedence(char op1, char op2) 
		{ 
			if (op2 == '(' || op2 == ')') 
				return false; 
			if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) 
				return false; 
			else
				return true; 
		} 

		public static int Operation(char op, int b, int a) 
		{ 
			if(op == '+') return a+b;
			else if(op == '-') return a-b;
			else if(op == '*') return a*b;
			else if(op == '/') {
				if(b==0) {
					return 0;
				}
				return a/b;
			}
			return 0;
		} 

		public static void main(String[] args) 
		{ 
			String exp = "((4 + ( 7 + 3 ) * ( 100*239 ) )";
			//String exp = "1 + 2 * 5";
			System.out.println(exp+ " = " +evaluate(exp));
			System.out.println(test.IsTrueBracket(exp.toCharArray()));
		} 
	}



