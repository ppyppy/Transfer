double power(double x, int n){
	if(n<0){
		x = 1/x;
		n = -n;
	}
	dboule ret = 1.0;
	while(n>0){
		if( (n&0x01) > 0 ){
			ret *= x;
		}
		x *= x;
		n >>>= 1;
	}
	return ret;
}

//Recursive
public double pow(double x, int n) {
    if(n==0)
        return 1;
    else if(n==1)
        return x;
    else if(n<0){
        n = -n;
        x = 1.0/x;
    }
    double temp = pow(x, n/2);
    if(n%2==0){
        return temp*temp;
    }else{
        return temp*temp*x;
    }
}