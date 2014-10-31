//A prime is an integer greater then one those only positive divisors are one and itself.
//
//The prime factorization of an integer is the multiset of primes those product is the integer.

List<Integer> primeFactorization(int n){
	List<Integer> factors = new ArrayList<Integer>();
	for(int i=2; i<=n; i++){
		while(n%i==0){
			factors.add(i);
			n /= i;
		}
	}
}

public static List<Integer> primeFactors(int n) {
    List<Integer> factors = new ArrayList<Integer>();
    for (int i = 2; i <= n / i; i++) { //check if i*i<=n
      while (n % i == 0) {
        factors.add(i);
        n /= i;
      }
    }
    if (n > 1) {  //add the n which not able to divide
      factors.add(n);
    }
    return factors;
  }