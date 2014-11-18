//Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle 
//containing all ones and return its area.

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0)
            return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[][] heights = new int[rows][cols];
        for(int i=0; i<rows; i++)
            for(int j=0; j<cols; j++){
                if(i==0)
                    heights[i][j] = matrix[i][j] - '0';
                else
                    heights[i][j] = (matrix[i][j]=='0') ? 0 : heights[i-1][j]+1;
            }
        int max = 0;
        for(int i=0; i<rows; i++){
            max = Math.max(max, largestRectangleArea(heights[i]));
        }
        return max;
    }
    
    public int largestRectangleArea(int[] height) {
        Stack<Integer> S = new Stack<Integer>();
        int sum = 0;
        int[] h = new int[height.length+1];
        expand(h, height);
        for (int i = 0; i < h.length; i++) {
        	 if ( S.empty() || (h[i]>h[S.peek()]) )
            	 S.push(i);
             else {
                  int tmp = S.pop();
                  sum = Math.max(sum, h[tmp]*(S.empty()? i : i-S.peek()-1));
                  i--;
             }
        }
        return sum;
   }
    public void expand(int[] h, int[] height){
        for(int i=0; i<height.length; i++)
        	h[i] = height[i];
        h[h.length-1] = 0;
    }
}