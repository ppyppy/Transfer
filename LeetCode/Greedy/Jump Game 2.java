//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Your goal is to reach the last index in the minimum number of jumps.
//
//For example:
//Given array A = [2,3,1,1,4]
//
//The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

    public int jump(int[] A) {
        if(A==null || A.length<=1)
            return 0;
        int range=0, preRange=0, step=0;
        for(int i=0; i<A.length; i++){
        	if(range<i) //not able to reach the current index
        		return -1;
            if(i>preRange){
                step++;
                preRange = range;
            }
            range = Math.max(range, i+A[i]);
        }
        if(preRange<A.length-1)
            return 0;
        return step;
    }