//1. suffix tree  http://en.wikipedia.org/wiki/Suffix_tree
//like bananas, also use sananab, to get the longest common subsequence anana

//2. O(n^2) Iterative

int getLongestPalindrome(String s){
	if(s==null || s.length()==0)
		return 0;
	int max = 0;
	for(int i=0; i<s.length(); i++){
		int len1 = maxLengthMiddle(i, s); //cabac
		int len2 = maxLengthMirror(i, s); //bcaacb
		int tempMax = len1 > len2 ? len1 : len2;
		if(tempMax>max)
			max = tempMax;
	}
	return max;
}

String getLongestPalindrome(String s){
	int len = s.length(), start=0, end=0;
	boolean[][] table = new boolean[len][len];
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