//Given an absolute path for a file (Unix-style), simplify it.
//
//For example,
//path = "/home/", => "/home"
//path = "/a/./b/../../c/", => "/c"
//click to show corner cases.
//
//Corner Cases:
//Did you consider the case where path = "/../"?
//In this case, you should return "/".
//Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
//In this case, you should ignore redundant slashes and return "/home/foo".

public class Solution {
    public String simplifyPath(String path) {
        if(path==null || path.length()==0)
            return null;
        Stack<String> stack = new Stack<String>();
        String[] array = path.split("/");
        
        for(String ch : array){
            switch (ch){
            	case "":
            		break;
                case "/":
                    break;
                case ".":
                    break;
                case "..":
                	if(!stack.isEmpty())
                		stack.pop();
                	break;
                default:
                    stack.push(ch);
                    break;
            }
        }
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
            sb.insert(0, '/');
        }
        if(sb.length()==0)
            sb.append('/');
        return sb.toString();
    }
}