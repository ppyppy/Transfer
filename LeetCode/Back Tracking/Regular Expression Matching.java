//Implement regular expression matching with support for '.' and '*'.
//
//'.' Matches any single character.
//'*' Matches zero or more of the preceding element.
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
//isMatch("aa", "a*") → true
//isMatch("aa", ".*") → true
//isMatch("ab", ".*") → true
//isMatch("aab", "c*a*b") → true

public class Solution {
    public boolean isMatch(String s, String p) {
        if(s==null && p==null)
            return true;
        if(s==null || p==null)
            return false;
        return helper(s.toCharArray(), 0, p.toCharArray(), 0);
    }
    
    boolean helper(char[] chs1, int index1, char[] chs2, int index2){
        if(index1==chs1.length && index2==chs2.length){
            return true;
        }else if(index1<chs1.length && index2==chs2.length){
            return false;
        }
        if( index2==(chs2.length-1) || chs2[index2+1]!='*' ){
            if(index1<chs1.length && (chs1[index1]==chs2[index2] || chs2[index2]=='.') ){
                return helper(chs1, index1+1, chs2, index2+1);
            }else{
                return false;
            }
        }else{
            if(helper(chs1, index1, chs2, index2+2)){
                return true;
            }
            for(;index1<chs1.length; index1++){
                if(chs1[index1]==chs2[index2] || chs2[index2]=='.'){
                    if(helper(chs1, index1+1, chs2, index2+2)){
                        return true;
                    }
                }else{
                    break;
                }
            }
            return false;
        }
    }
}
