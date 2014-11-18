//Given a string s, partition s such that every substring of the partition is a palindrome.
//
//Return all possible palindrome partitioning of s.
//
//For example, given s = "aab",
//Return
//
//  [
//    ["aa","b"],
//    ["a","a","b"]
//  ]

public class Solution {
    	public List<List<String>> partition(String s) {
    		if(s==null || s.length()==0)
    			return null;
    		int len = s.length();
    		boolean[][] table = new boolean[len][len];
    		getLongestPalindrome(s, table);
    		return helper(s, table, 0);
    	}
    	
    	List<List<String>> helper(String s, boolean[][] table, int index){
    		List<List<String>> lists = new ArrayList<List<String>>();
    		if(index==table.length){
    			lists.add(new ArrayList<String>());
    			return lists;
    		}
    		for(int i=index; i<table.length; i++){
    			if(table[index][i]==true){
    				for(List<String> list : helper(s, table, i+1)){
    					list.add(0, s.substring(index, i+1));
    					lists.add(list);
    				}
    			}
    		}
    		return lists;
    	}
    	
    	String getLongestPalindrome(String str, boolean[][] table){
    		int maxLen = 1, s=0, e=0;
    		int len = table.length;
    		for(int i=0; i<len; i++){
    			table[i][i] = true;
    		}
    		for(int i=1; i<len; i++){
    			if(str.charAt(i) ==str.charAt(i-1))
    				table[i-1][i] = true;
    			if(2>maxLen){
    				s = i-1;
    				e = i;
    			}
    		}
    		for(int l=3; l<=len; l++){
    			for(int i=0; i<=len-l; i++){
    				int j=i+l-1;
    				if(str.charAt(i)==str.charAt(j) && table[i+1][j-1]==true){
    					table[i][j] = true;
    					if(len>maxLen){
    						s = i;
    						e = j;
    					}
    				}
    			}
    		}
    		return str.substring(s, e+1);
    	}
}