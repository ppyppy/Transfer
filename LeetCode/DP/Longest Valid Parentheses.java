//Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//
//For "(()", the longest valid parentheses substring is "()", which has length = 2.
//
//Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

public class Solution {
    public int longestValidParentheses(String s) {
        if(s==null || s.length()==0)
            return 0;
        int max=0;
        LinkedList<Node> stack = new LinkedList<Node>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==')' && !stack.isEmpty() && stack.getFirst().ch=='(')
                stack.removeFirst();
            else
                stack.addFirst(new Node(i+1, s.charAt(i)));
        }
        if(stack.isEmpty())
            return s.length();
        int pre = -1;
        while(!stack.isEmpty()){
        	int cur = stack.removeFirst().index;
        	if(pre==-1){
        		if( (s.length()-cur)>max )
        				max = s.length()-cur;
        	}else{
        		if( (pre-cur-1)>max )
        				max = (pre-cur-1);
        	}
        	pre = cur;
        }
        if( (pre-1)>max )
        	max = pre-1;
        return max;
    }
}

class Node{
	public int index;
	public char ch;
	public Node(int val, char ch){
		this.index = val;
		this.ch = ch;
	}
}