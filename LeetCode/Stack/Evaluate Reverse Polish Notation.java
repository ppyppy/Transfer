//Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
//Some examples:
//  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

public class Solution {
	public int evalRPN(String[] tokens) {
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int a = 0, b = 0;
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].length() == 1) {
				char ch = tokens[i].charAt(0);
				switch (ch) {
				case '+':
					a = stack.removeLast();
					b = stack.removeLast();
					stack.addLast(a + b);
					break;
				case '-':
					a = stack.removeLast();
					b = stack.removeLast();
					stack.addLast(b - a);
					break;
				case '*':
					a = stack.removeLast();
					b = stack.removeLast();
					stack.addLast(a * b);
					break;
				case '/':
					a = stack.removeLast();
					b = stack.removeLast();
					stack.addLast(b / a);
					break;
				default:
					stack.addLast(Integer.parseInt(tokens[i]));
					break;
				}
			}else{
				stack.addLast(Integer.parseInt(tokens[i]));
			}
		}
		return stack.removeLast();
	}
}