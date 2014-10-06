public class Solution {
    public int maxProduct(int[] A) {
        if(A==null || A.length==0)
            return 0;
        int product = 1, max = Integer.MIN_VALUE;
        for(int i=0; i<A.length; i++){
            product = product*A[i];
            if(product>max)
                max = product;
            if(product==0)
                product = 1;
        }
        product = 1;
        for(int i=A.length-1; i>=0; i--){
            product = product*A[i];
            if(product>max)
                max = product;
            if(product==0)
                product = 1;
        }
        return max;
    }
}