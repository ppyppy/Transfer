//integer sequence first ascending then descending, find the max
// 1 3 5 9 15 10 9 7 5

int findMax(int[] nums){
	if(nums==null || nums.length==0)
		throw new RuntimeException("number is invalid!");
	int low=0, high=nums.length-1;
	while(low<high){
		int mid = (low+high+1)/2;  //get the upper bound
		if(mid==0 || nums[mid]>=nums[mid-1]){
			low = mid;
		}else{
			high = mid-1;
		}
	}
	return nums[low];
}
	