// dp solution

int climbStairs(int n){
	if(n<=1)
		return n;
	int ret = 0, f0 = 1, f1 = 1;
	for(int i=2; i<=n; i++){
		ret = f0 + f1;
		f0 = f1;
		f1 = ret;
	}
	return ret;
}