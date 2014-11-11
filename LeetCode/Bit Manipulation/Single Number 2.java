//Given an array of integers, every element appears three times except for one. Find that single one.
//
//Note:
//Your algorithm should have a linear runtime complexity. 
//Could you implement it without using extra memory?

public int singleNumber(int[] A) {
	int[] bitCount = new int[32];
	for(int i=0; i<A.length; i++)
		for(int j=0; j<32; j++){
			if( ((A[i]>>>j) & 0x01) > 0 ){
				bitCount[j]++;
			}
		}
	int ret = 0;
	for(int j=0; j<32; j++){
		if( (bitCount[j]%3) != 0){
			ret |= (1<<j);
		}
	}
	return ret;
    }
}