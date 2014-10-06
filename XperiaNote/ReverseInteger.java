int ReverseInteger(int n){
	if(n<=9)
		return n;
	int m = 0;
	while(n>0){
		m += n%10;
		n /= 10;
		if(n>0)
			m *= 10;
	}
	return m;
}