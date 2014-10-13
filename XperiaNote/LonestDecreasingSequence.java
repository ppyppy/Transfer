//	longest decreasing subsequence 
// 9 4 3 2 5 4 3 2 => 9 5 4 3 2
	public static Stack<Integer> GetLongestIncreasingSubSequence(int[] nums){
		int length = nums.length;
		int[] nl = new int[length];
		int[] pre = new int[length];
		for(int i=0; i<length; i++){
			nl[i] = 1;
			pre[i] = i;
		}
		int index = -1, max = 0;
		for(int i=1; i<length; i++)
			for(int j=0; j<i; j++){
				if(nums[j]>nums[i] && (nl[j]+1)>nl[i]){
					nl[i] = nl[j]+1;
					pre[i] = j;
					if(nl[i]>max){
						max = nl[i];
						index = i;
					}
				}
			}
		Stack<Integer> stack = new Stack<Integer>();
		while(pre[index]!=index){
			stack.add(nums[index]);
			index = pre[index];
		}
		stack.add(nums[index]);
		return stack;
	}
