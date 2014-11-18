//'?' Matches any single character.
//'*' Matches any sequence of characters (including the empty sequence).
//
//The matching should cover the entire input string (not partial).
//
//The function prototype should be:
//bool isMatch(const char *s, const char *p)
//
//Some examples:
//isMatch("aa","a") → false
//isMatch("aa","aa") → true
//isMatch("aaa","aa") → false
//isMatch("aa", "*") → true
//isMatch("aa", "a*") → true
//isMatch("ab", "?*") → true
//isMatch("aab", "c*a*b") → false

public class Solution {
       public boolean isMatch(String s, String p) {
           if(s==null && p==null)
               return true;
           if(s==null || p==null)
               return false;
           return helper(s.toCharArray(), 0, p.toCharArray(), 0);
       }
       
       boolean helper(char[] chs1, int k1, char[] chs2, int k2){
           if(k1==chs1.length && k2==chs2.length){
               return true;
           }else if(k1<chs1.length && k2==chs2.length){
               return false;
           }
           if(k1<chs1.length){
        	   if(k2<chs2.length && (chs1[k1]==chs2[k2] || chs2[k2]=='?') ){
        		   return helper(chs1, k1+1, chs2, k2+1);
        	   }else if(k2<chs2.length && chs2[k2]=='*'){
        		   for(;k1<chs1.length; k1++){
            		   if(helper(chs1, k1, chs2, k2+1))
            			   return true;
        		   }
        	   }
           }
		   while(k2<chs2.length && chs2[k2]=='*'){
			   k2++;
		   }
           return k2==chs2.length;
       }
}

public class Solution {
    public boolean isMatch(String s, String p) {
        if(s==null && p==null)
            return true;
        if(s==null || p==null)
            return false;
        int i=0, j=0, pre1=-1, pre2=-1;
        char[] chs1 = s.toCharArray();
        char[] chs2 = p.toCharArray();
        while(i<chs1.length){
            if(j<chs2.length && (chs1[i]==chs2[j] || chs2[j]=='?') ){
                i++; j++;
            }else if(j<chs2.length && chs2[j]=='*'){
                pre1 = i;
                pre2 = j;
                j++; //skip *
            }else if(pre1!=-1){
                i = ++pre1;
                j = pre2+1;
            }else{
                return false;
            }
        }
        while(j<chs2.length && chs2[j]=='*'){
            j++;
        }
        return j==chs2.length;
    }
}