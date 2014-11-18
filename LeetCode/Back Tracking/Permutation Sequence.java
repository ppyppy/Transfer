//The set [1,2,3,…,n] contains a total of n! unique permutations.
//
//By listing and labeling all of the permutations in order,
//We get the following sequence (ie, for n = 3):
//
//"123"
//"132"
//"213"
//"231"
//"312"
//"321"
//Given n and k, return the kth permutation sequence.
//
//Note: Given n will be between 1 and 9 inclusive.

public class Solution {
    public String getPermutation(int n, int k) {
        if( k<0 || k>factorial(n) )
            return "";
        int[] index = new int[n];
        for(int i=n-1; i>=0; i--){
            int value = factorial(i);
            while( k-1>=value ){
                k -= value;
                index[n-1-i]++;
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i=1; i<=n; i++)
            list.add(i);
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<index.length; i++){
            sb.append(list.get(index[i]));
            list.remove(index[i]);
        }
        return sb.toString();
    }
    private int factorial(int n){
        int sum=1;
        while(n>0){
            sum*=n;
            n--;
        }
        return sum;
    }
}