//bad solution
	String LCS(String s1, String s2, StringBuilder lcs){
		if(s1.length()==0 || s2.length()==0)
			return lcs.toString();
		if(s1.charAt(0)==s2.charAt(0)){
			lcs.append(s1.charAt(0));
			return LCS(s1.substring(1), s2.substring(1), lcs);
		}else{
			StringBuilder tmp1= new StringBuilder(), tmp2=new StringBuilder(), tmp3=new StringBuilder();
			LCS(s1.substring(1), s2.substring(1), tmp1);
			LCS(s1.substring(1), s2, tmp2);
			LCS(s1, s2.substring(1), tmp3);
			StringBuilder mid = tmp1.length()>tmp2.length() ? tmp1 : tmp2;
			lcs = mid.length()>tmp3.length() ? mid : tmp3;
			return lcs.toString();
		}
	}
//	   A B C D E F G H
//   0 0 0 0 0 0 0 0 0
// E 0 0 0 0 0 1 0 0 0
// E 0 0 0 0 0 1 0 0 0
// F 0 0 0 0 0 0 2 0 0
// G 0 0 0 0 0 0 0 3 0
// A 0 1 0 0 0 0 0 0 0
// B 0 0 2 0 0 0 0 0 0
	
	int LCSubString(String s1, String s2){
		if(s1==null || s2==null)
			return 0;
		int m = s1.length(), n = s2.length();
		int[][] mat = new int[m+1][n+1];
		int maxLen = 0;
		for(int i=0; i<=m; i++)
			for(int j=0; j<=n; j++){
				if(i==0 || j==0)
					mat[i][j]=0;
				else if(s1.charAt(i-1)==s2.charAt(j-1)){
					mat[i][j] = mat[i-1][j-1]+1;
					if(mat[i][j]>maxLen)
						maxLen = mat[i][j];
				}else{
					mat[i][j] = 0;
				}
			}
		return maxLen;
	}
