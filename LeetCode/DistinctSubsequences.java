//Given a string S and a string T, count the number of distinct subsequences of T in S.
//
//A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of 
//the characters without disturbing the relative positions of the remaining characters. 
//(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//
//Here is an example:
//S = "rabbbit", T = "rabbit"
//
//Return 3.

//  a b c c e a c e
//a 1 1 1 1 1 1 1 1 1
//c 0 1 1 1 1 1 2 2 2
//e 0 0 0 1 2 2 2 4 4
//  0 0 0 0 0 2 2 2 6

	    public int numDistinctSubsequence(String s, String t){
	    	char[] schs = s.toCharArray();
	    	char[] tchs = t.toCharArray();
	    	int[][] dp = new int[t.length()+1][s.length()+1];
	    	for(int j=0; j<dp[0].length; j++)
	    		dp[0][j] = 1;
	    	for(int i=1; i<dp.length; i++)
	    		dp[i][0] = 0;
	    	for(int i=1; i<dp.length; i++)
	    		for(int j=1; j<dp[0].length; j++){
	    			dp[i][j] = dp[i][j-1] + ( (schs[j-1]==tchs[i-1]) ? dp[i-1][j-1] : 0 );
	    		}
	    	return dp[t.length()][s.length()];
	    }