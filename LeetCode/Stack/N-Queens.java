//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

public class Solution {
    public boolean isValid(String s) {
        if(s==null)
            return true;
        LinkedList<Character> stack = new LinkedList<Character>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(stack.isEmpty())
                stack.addFirst(ch);
            else{
               switch (ch){
        	    case ')':
        	        if(stack.getFirst()=='(')
        	            stack.removeFirst();
        	        else
        	            return false;
        		    break;
        	    case ']':
        	       if(stack.getFirst()=='[')
        	            stack.removeFirst();
        	        else
        	            return false;
        		    break;
            	case '}':
            	   if(stack.getFirst()=='{')
        	            stack.removeFirst();
        	        else
        	            return false;
        		    break;
        	    default:
        	        stack.addFirst(ch);
        		    break;
               }
            }
        }//for
        return stack.isEmpty();
    }
}