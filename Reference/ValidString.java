//一个int N，让输出所有的长度为N的valid string的个数，valid string的
//定义是由A,B,C三种字母组成，并且在这个string中任意连续的三个字母不能包括A,B,C
//三个字母，比如BACCA就不是valid string，因为前三个字母B,A,C包含了这三个字母。
//dp[i]['A'] = (dp[i-1]['B'] - dp[i-2]['C']) + (dp[i-1]['C'] - dp[i-2]['B']) + dp[i-1]['A']
//dp[0]['A'] = dp[0]['B'] = dp[0]['C'] = 1;
//dp[1]['A'] = dp[1]['B'] = dp[1]['C'] = 3;
//Resule: dp[n]['A'] + dp[n]['B'] + dp[n]['C']

   int validString(int n){
		 if(n<=0)
			 return 0;
		 if(n==1)
			 return 3;
		 int[][] dp = new int[n][3];
		 dp[0][0] = dp[0][1] = dp[0][2] = 1;
		 dp[1][0] = dp[1][1] = dp[1][2] = 3;
		 for(int i=2; i<n; i++){
			 dp[i][0] = dp[i-1][0] + (dp[i-1][1]-dp[i-2][2]) + (dp[i-1][2]-dp[i-2][1]);
			 dp[i][1] = dp[i-1][1] + (dp[i-1][2]-dp[i-2][0]) + (dp[i-1][0]-dp[i-2][2]);
			 dp[i][2] = dp[i-1][2] + (dp[i-1][1]-dp[i-2][0]) + (dp[i-1][0]-dp[i-2][1]);
		 }
		 return dp[n-1][0]+dp[n-1][0]+dp[n-1][0];
	 }