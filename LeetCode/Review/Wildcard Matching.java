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
         return isMatch(s.toCharArray(), p.toCharArray());
    }
    
    private boolean isMatch(char[] shs, char[] phs){
       int i=0, j=0;
       int pri=-1, prj=-1;
       while( i<shs.length ){ //j shouldn't go here since when has '*', j can go back again.
           if( j<phs.length && (shs[i]==phs[j] || phs[j]=='?') ){
               i++;
               j++;
           }else if(j<phs.length && phs[j]=='*'){
               pri = i;
               prj = j++;//skip '*'
           }else if(pri!=-1){
               i = ++pri;
               j = prj+1;
           }else{
               return false;
           }
       }
       while(j<phs.length && phs[j]=='*'){
           j++;
       }
       return j==phs.length;
    }
}