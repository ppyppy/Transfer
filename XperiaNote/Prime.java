	 boolean isPrime(int n){
		 if(n<2)
			 return false;
		 if(n%2==0)
			 return false;
		 for(int i=3; i*i<=n; i+=2)
			 if(n%i==0)
				 return false;
		 return true;
	 }
	 
	 //find all the prime numbers
	 boolean[] findPrimes(boolean[] nums){
		 if(nums==null || nums.length==0)
			 return;
		 Arrays.fill(nums, true);
		 for(int i=2; i<nums.length; i++){
			 if(nums[i]==true){
				 for(int j=2; i*j<nums.length; j++){
					 nums[i*j] = false;
				 }
			 }
		 }
		 return true;
	 }
	 
