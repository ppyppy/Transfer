//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//Integers in each row are sorted from left to right.
//The first integer of each row is greater than the last integer of the previous row.
//For example,
//
//Consider the following matrix:
//
//[
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//Given target = 3, return true.

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0)
            return false;
        int rows = matrix.length, cols = matrix[0].length;
        int start = 0, end = rows*cols-1;
        int val = 0;
        while(start<=end){
            int mid = (start+end)/2;
            val = matrix[mid/cols][mid%cols];
            if( val == target )
                return true;
            else if( val<target)
                start = mid+1;
            else
                end = mid-1;
        }
        return false;
    }
}
