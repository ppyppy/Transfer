//Given a string S and a string T, count the number of distinct subsequences of T in S.
//
//A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//
//Here is an example:
//S = "rabbbit", T = "rabbit"
//
//Return 3.

public class Solution {
    private int count = 0;
    public int numDistinct(String S, String T) {
        if(T==null)
            return 1;
        if(S==null)
            return 0;
        char[] tchs = T.toCharArray();
        char[] schs = S.toCharArray();
        int[][] dp = new int[tchs.length+1][schs.length+1];
        for(int i=1; i<dp.length; i++)
            dp[i][0] = 0; //which s is empty
        for(int j=0; j<dp[0].length; j++)
            dp[0][j] = 1;
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                dp[i][j] = dp[i][j-1] + ( (tchs[i-1]==schs[j-1]) ? dp[i-1][j-1] : 0 );
            }
        }
        return dp[tchs.length][schs.length];
    }
}