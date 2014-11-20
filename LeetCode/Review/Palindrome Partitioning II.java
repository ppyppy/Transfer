//Given a string s, partition s such that every substring of the partition is a palindrome.
//
//Return the minimum cuts needed for a palindrome partitioning of s.
//
//For example, given s = "aab",
//Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

public class Solution {
    public int minCut(String s) {
        if(s==null || s.length()<=1)
        	return 0;
        int len = s.length();
        boolean[][] table = new boolean[len][len];
        int[] dp = new int[len+1];
        for(int i=0; i<=len; i++)
            dp[i] = len-i;
        for(int i=len-1; i>=0; i--){
            for(int j=i; j<len; j++){
                if(s.charAt(i)==s.charAt(j)){
                    if( ((i+1)>(j-1)) || table[i+1][j-1]==true ){
                        table[i][j] = true;
                        dp[i] = Math.min(dp[i], dp[j+1]+1);
                    }
                }
            }
        }
        return dp[0]-1;
    }
}