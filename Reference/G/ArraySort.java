//2. 给一个数组 数组中的数字先增大后减小  求数组中最大和最小的数字 比如说数组 
//1 2 3 4 3 2 0  最小数字0 最大4  最小数字很好求  是头或尾位置最小的数字  求最
//大数字的时候用二叉查找  对数复杂度

	int max = 0;
	int getBiggest(int[] nums){
		if(nums==null || nums.length==0){
			return -1;
		}
		helper(nums, 0, nums.length-1);
		return max;
	}
	
	void helper(int[] nums, int low, int high){
		if(low>high)
			return;
		int mid = (low+high)/2;
		if(nums[low]>nums[mid] || nums[high]>nums[mid]){
			int tmp = Math.max(nums[low], nums[high]);
			if(tmp>max)
				max = tmp;
			return;
		}
		if(nums[mid]>max)
			max = nums[mid];
		helper(nums, low, mid-1);
		helper(nums, mid+1, high);
	}