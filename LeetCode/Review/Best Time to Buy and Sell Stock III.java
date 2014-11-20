//Say you have an array for which the ith element is the price of a given stock on day i.
//
//Design an algorithm to find the maximum profit. You may complete at most two transactions.
//
//Note:
//You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null)
            return 0;
        int len = prices.length;
        int[] f1 = new int[len];
        int[] f2 = new int[len];
        int min = Integer.MAX_VALUE;
        int maximum = 0;
        for(int i=0; i<prices.length; i++){
            if(prices[i]<min)
                min = prices[i];
            if( (prices[i]-min)>maximum ){
                maximum = prices[i]-min;
            }
            f1[i] = maximum;
        }
        int max = Integer.MIN_VALUE;
        maximum = 0;
        for(int i=prices.length-1; i>=0; i--){
            if(prices[i]>max)
                max = prices[i];
            if( (max-prices[i])>maximum ){
                maximum = max-prices[i];
            }
            f2[i] = maximum;
        }
        int sum = 0;
        for(int i=0; i<len; i++){
            if( (f1[i]+f2[i])>sum )
                sum = f1[i]+f2[i];
        }
        return sum;
    }
}