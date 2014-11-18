import java.util.Arrays;
import java.util.Stack;

//Given n non-negative integers representing the histogram's 
//bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
//
//
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
//
//
//The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
//For example,
//Given height = [2,1,5,6,2,3],
//return 10.

public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height==null || height.length==0)
        	return 0;
        int[] h = new int[height.length+1];
        for(int i=0; i<height.length; i++)
        	h[i] = height[i];
        h[h.length-1] = 0;  //expand 1 to make sure last element is 0
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int i=0; i<h.length; i++){
        	if(stack.isEmpty() || h[i]>h[stack.peek()]){
        		stack.add(i);
        	}
        	else{
        		int j = stack.pop();
        		max = Math.max(max, stack.isEmpty() ? h[j]*i : h[j]*(i-stack.peek()-1) );
        		i--;
        	}
        }
        return max;
    }
}