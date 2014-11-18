//Given an array with n objects colored red, white or blue, 
//sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//
//Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//
//Follow up:
//A rather straight forward solution is a two-pass algorithm using counting sort.
//First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with 
//total number of 0's, then 1's and followed by 2's.
//
//Could you come up with an one-pass algorithm using only constant space?

public class Solution {
    public void sortColors(int[] A) {
        if(A==null)
            return;
        int s=0, e=A.length-1;
        int i=0;
        while(i<=e){
            if(A[i]==0){
                replace(A, s, i);
                s++;
                i++;
                continue;
            }else if(A[i]==2){
                replace(A, e, i);
                e--;
                continue;
            }
            i++;
        }
    }
    
    private void replace(int[] A, int a, int b){
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
