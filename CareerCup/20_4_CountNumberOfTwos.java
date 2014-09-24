//f(513) = 5*f(99) + f(13) + 100;
//f(279) = 2*f(99) + f(79) + 79+1; (200~279)

int countTwos(int n){
	if(n<2)
		return 0;
	int power = 1, count = 0;
	while( 10*power<n )
		power *= 10;
	int first = n/power;
	int remainder = n%power;
	if(first>2)
		count += power;
	else if(first==2)
		count += (remainder+1);
	count += ( first*countTwos(power-1) + countTwos(remainder) );
	return count;
}