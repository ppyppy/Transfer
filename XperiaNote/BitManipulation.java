//Judge a num is a power of 2 (2^n) ?
boolean isPowerOfTwo(unsigned int n){
	return n&(n-1);
}

//count the 1's of binary number
int count(unsigned int n){
	int r = 0;
	while(n>0){
		n &= n-1;
		r++;
	}
	return r;
}

//get the nearest number to the power of 2
boolean highPowerofTwo(unsigned int n){
	if(n<=1)
		return 1;
	while(!isPowerofTwo(n)){
		n = n|(n-1) + 1;
	}
	return n;
}

//implement of divide
int div1(int divident, int divisor){
	if(divisor==0)
		throw new RuntimeException("Invalid divisor!");
	int res = 0;
	while( (divident-divisor)>=0 ){
		divident -= divisor;
		res++;
	}
	return res;
}


int div2(int divident, int divisor){
	if(divisor==0)
		throw new RuntimeException("Invalid divisor!");
	if(divident<divisor)
		return 0;
	int k = 0, c = divisor;
	for(; divident>=c; k++, c<<=1){
		if( (divident-c)<divisor ){
			return 1<<k;
		}
	}
	return div2(divident-c>>>1, divisor) + 1<<(k-1);
}
