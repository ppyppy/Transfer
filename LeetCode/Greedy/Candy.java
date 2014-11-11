//There are N children standing in a line. Each child is assigned a rating value.
//
//You are giving candies to these children subjected to the following requirements:
//
//Each child must have at least one candy.
//Children with a higher rating get more candies than their neighbors.
//What is the minimum candies you must give?

public class Solution {
    public int candy(int[] ratings) {
        if(ratings==null || ratings.length==0)
            return 0;
        int len = ratings.length;
        int[] count = new int[len];
        for(int i=0; i<len; i++){
        	if(i==0)
        		count[i]=1;
        	else if(ratings[i]>ratings[i-1]){
        		count[i] = count[i-1]+1;
        	}else{
        		count[i]=1;
        	}
        }
        int[] rcount = new int[len]; 
        for(int i=len-1; i>=0; i--){
        	if(i==len-1)
        		rcount[i] = 1;
        	else if(ratings[i]>ratings[i+1]){
        		rcount[i] = rcount[i+1]+1;
        	}else{
        		rcount[i] = 1;
        	}
        }
        int sum = 0;
        for(int i=0; i<len; i++)
        	sum += Math.max(count[i], rcount[i]);
        return sum;
    }
}