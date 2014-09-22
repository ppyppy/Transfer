//find num in the rotated array

	int search(int[] nums, int low, int high, int key){
		if(nums==null || nums.length==0)
			return -1;
		int mid = 0;
		while(low<=high){
			mid = (low+high)/2;
			if(nums[mid]==key)
				return mid;
			else if(nums[low]<=nums[mid]){
				if(nums[mid]<key)
					low = mid+1;
				else if(key>=nums[low])
					high = mid-1;
				else
					low = mid+1;
			}else{
				if(nums[mid]>key)
					high = mid-1;
				else if(key<=nums[high])
					low = mid+1;
				else
					high = mid-1;
			}
		}
		return -1;
	}