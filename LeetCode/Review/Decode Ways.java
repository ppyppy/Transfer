//A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//Given an encoded message containing digits, determine the total number of ways to decode it.
//
//For example,
//Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//
//The number of ways decoding "12" is 2.

public class Solution {
    int sum = 0;
    public int numDecodings(String s) {
        if(s==null || s.length()==0 )
            return 0;
        sum = 0;
        helper(s, 0);
        return sum;
    }
    void helper(String s, int index){
        if(index==s.length()){
            sum ++;
            return;
        }
        helper(s, index+1);
        if(index<s.length()-1){
            String sub = s.substring(index, index+2);
            if(Integer.parseInt(sub)<=26)
                helper(s, index+2);
        }
    }
}


public class Solution {
    private int sum;
    public int numDecodings(String s) {
        if(s==null || s.length()==0)
            return 0;
        if( !isFit(s.substring(0, 1)) ){
            return 0;
        }
        int[] dp = new int[s.length()+1];
        dp[0] = 1; dp[1] = 1;
        for(int i=1; i<s.length(); i++){
            if(isFit(s.substring(i-1, i+1))){
                dp[i+1] += dp[i-1];
            }
            if(isFit(s.substring(i, i+1))){
                dp[i+1] += dp[i];
            }
        }
        return dp[s.length()];
    }
    
    private boolean isFit(String s){
        if(s.charAt(0)=='0')
            return false;
        int num = Integer.parseInt(s);
        if( num>=1 && num<=26)
            return true;
        return false;
    }
}
