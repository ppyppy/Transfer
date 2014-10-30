//Given a list of 'N' coins, their values being in an array A[], return the minimum number of coins required to sum to 'S'

int minCoins(ArrayList<Integer> coins, int key){
	if(key<=0)
		return 0;
	if(coins==null)
		throw new RuntimeException("no coins");
	int[] dp = new int[key+1];
	Arrays.fill(dp, Integer.MAX_VALUE);
	dp[0] = 0;
	for(int i=1; i<dp.length; i++)
		for(int j=0; j<coins.size(); j++){
			if( (i-coins.get(j))>=0 && (dp[i-coins.get(j)]+1)<dp[i]){
				dp[i] = dp[i-coins.get(j)]+1;
			}
		}
	return dp[key];
}