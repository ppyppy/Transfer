//Follow up for "Find Minimum in Rotated Sorted Array":
//What if duplicates are allowed?
//
//Would this affect the run-time complexity? How and why?
//Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//Find the minimum element.
//
//The array may contain duplicates.

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
            }else if( num[mid]==num[l]&&mid!=l&&num[mid]!=num[h] ){
                min = Math.min(min, num[l]);
                l = mid+1;
            }else{
                min = Math.min(min, num[l]);
                l++;
            }
        }
        return min;
    }
}