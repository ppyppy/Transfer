//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Determine if you are able to reach the last index.
//
//For example:
//A = [2,3,1,1,4], return true.
//
//A = [3,2,1,0,4], return false.

public class Solution {
    public boolean canJump(int[] A) {
        if(A==null || A.length==0)
            return true;
        int[] dp = new int[A.length];
        dp[0] = A[0];
        if( dp[0]>=(A.length-1) )
            return true;
        for(int i=1; i<A.length; i++){
            if(dp[i-1]>=i){
                dp[i] = Math.max(dp[i-1], i+A[i]);
                if(dp[i]>=A.length-1)
                    return true;
            }else{
                return false;
            }
        }
        return false;
    }
}