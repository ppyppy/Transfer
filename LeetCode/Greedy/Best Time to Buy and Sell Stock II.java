//Say you have an array for which the ith element is the price of a given stock on day i.
//
//Design an algorithm to find the maximum profit. 
//You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
//However, you may not engage in multiple transactions at the same time 
//(ie, you must sell the stock before you buy again).
public class Solution {
    public int maxProfit(int[] prices) {
        int d1=-1, d2=-1;
        int sum = 0;
        for(int i=0; i<prices.length; i++){
            if(d1<0)
                d1 = prices[i];
            d2 = prices[i];
            if(d2>d1)
                sum += d2-d1;
            d1 = d2;
        }
        return sum;
    }
}

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<2)
            return 0;
        int start=0, profit=0, sum=0;
        for(int i=1; i<prices.length; i++){
            int cur = prices[i]-prices[start];
            if(cur<profit){
                sum += profit;
                profit = 0;
                start = i;
            }else if(cur>profit){
                profit = cur;
            }
        }
        if(profit>0)
            sum += profit;
        return sum;
    }
}