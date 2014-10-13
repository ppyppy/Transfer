//array of sequence, find the first sequence which sums to a value

ArrayList<Integer> findSequence(int[] nums, int value){
	ArrayList<Integer> list = new ArrayList<Integer>();
	if(nums==null || nums.length==0)
		return list;
	int sum = 0, first = 0;
	for(int i=0; i<nums.length; i++){
		sum += nums[i];
		list.add(nums[i]);
		while(sum>value){
			first =  list.remove(0);
			sum -= first;
		}
		if(sum==value)
			break;
	}
	return list;
}