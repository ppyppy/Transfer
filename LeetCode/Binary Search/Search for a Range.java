//Given a sorted array of integers, find the starting and ending position of a given target value.
//
//Your algorithm's runtime complexity must be in the order of O(log n).
//
//If the target is not found in the array, return [-1, -1].
//
//For example,
//Given [5, 7, 7, 8, 8, 10] and target value 8,
//return [3, 4].

public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] ret = {-1, -1};
        if(A==null || A.length==0){
            return ret;
        }
        int l=0, h=A.length-1;
        while(l<=h){
            int mid = (l+h)/2;
            if(A[mid]==target){
                ret = getRange(A, mid);
                return ret;
            }else if(A[mid]<target){
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        return ret;
    }
    
    private int[] getRange(int[] A, int index){
        int[] ret = {-1, -1};
        while(index>0 && A[index-1]==A[index])
            index--;
        ret[0] = index;
        while(index<A.length-1 && A[index]==A[index+1])
            index++;
        ret[1] = index;
        return ret;
    }
}