//Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//Find the minimum element.
//
//You may assume no duplicate exists in the array.

public class Solution {
    public int findMin(int[] num) {
        if(num==null || num.length==0)
            return 0;
        int l=0, h=num.length-1, min=num[0];
        while(l<=h){
            int mid = (l+h)/2;
            if(num[mid]>num[l]){
                min = Math.min(min, num[l]);
                l = mid+1;
            }else if(num[mid]<num[l]){
                min = Math.min(min, num[mid]);
                h = mid-1;
            }else{
                min = Math.min(min, num[l]);
                l++;
            }
        }
        return min;
    }
}