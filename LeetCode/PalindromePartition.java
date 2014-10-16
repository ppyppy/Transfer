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
	        int len = s.length();
		    boolean[][] table = new boolean[len][len];
		    getLongestPalindrome(s, table);
		    return partitionHelper(table, 0, s);
	    }

	  List<List<String>> partitionHelper(boolean[][] table, int index, String s){
		List<List<String>> lists = new ArrayList<List<String>>();
		if(index==s.length()){
			lists.add(new ArrayList<String>());
			return lists;
		}
		for(int i=index; i<s.length(); i++){
			if(table[index][i]==true){
				for(List<String> list : partitionHelper(table, i+1, s)){
					list.add(0, s.substring(index, i+1));
					lists.add(list);
				}
			}
		}
		return lists;
	  }

	  String getLongestPalindrome(String s, boolean[][] table){
		int len = s.length(), start=0, end=0;
		for(int i=0; i<len; i++)
			table[i][i] = true;
		for(int i=0; i<len-1; i++){
			if(s.charAt(i)==s.charAt(i+1)){
				table[i][i+1] = true;
				start = i;
				end= i+1;
			}
		}
		for(int l=3; l<=len; l++){
			for(int i=0; i<=len-l; i++){
				int j=i+l-1;
				if(s.charAt(i)==s.charAt(j) && table[i+1][j-1]==true){
					table[i][j] = true;
					start = i;
					end = j;
				}
			}
		}
		return s.substring(start, end+1);
	  }
}