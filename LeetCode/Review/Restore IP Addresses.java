//Given a string containing only digits, restore it by returning all possible valid IP address combinations.
//
//For example:
//Given "25525511135",
//
//return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

public class Solution {
        public List<String> restoreIpAddresses(String s) {
       	 List<String> list = new ArrayList<String>();
           if(s==null || s.length()<4)
               return list;
           helper(s, 0, 0, new StringBuffer(), list);
           return list;
       }
       private void helper(String s, int index, int splitNum, StringBuffer sb, List<String> list){
   		if (splitNum==3 && index<s.length()){
   		    String str = s.substring(index, s.length());
   			if( isValid(str) ){
   			    sb.append(".").append(str);
   			    list.add(sb.toString().substring(1)); //delete the first '.'
   			    sb.setLength(sb.length()-str.length()-1); //restore sb
   			}
   			return;
   		}
   		for (int i = index+1; i<s.length()&&(i-index)<=3; i++) {
   			String sub = s.substring(index, i);
   			if(isValid(sub)){
   			    sb.append(".").append(sub);
   				helper(s, i, splitNum+1, sb, list);
   				sb.setLength(sb.length()-sub.length()-1); //restore sb
   			}
   		}
       }
       private boolean isValid(String str){
       	if(str.length()==1 && str.equals("0"))
       		return true;
       	else if(str.length()>0 && str.length()<4 && Integer.parseInt(str)<=255 && str.charAt(0)!='0')
       		return true;
       	else
       		return false;
       }
}