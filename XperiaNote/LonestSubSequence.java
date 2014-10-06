//if it is continous, normall it mean not continuous
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
//	   B D C A B A
//   0 0 0 0 0 0 0
// A 0 0 0 0 1 1 1
// B 0 1 1 1 1 2 2
// C 0 1 1 2 2 2 2
// B 0 1 1 2 2 3 3
// D 0 1 2 2 2 3 3
// A 0 1 2 2 3 3 4
// B 0 1 2 2 3 4 4
	
	int[][] generateMatrix(String s1, String s2){
		if(s1==null || s2==null)
			return null;
		int len1 = s1.length()+1, len2 = s2.length()+1;
		int[][] mat = new int[len1][len2];
		for(int i=0; i<len1; i++)
			mat[i][0] = 0;
		for(int j=0; j<len2; j++)
			mat[0][j] = 0;
		for(int i=1; i<len1; i++)
			for(int j=1; j<len2; j++){
				if(s1.charAt(i-1)==s2.charAt(j-1))
					mat[i][j] = mat[i-1][j-1]+1;
				else if(mat[i-1][j]<mat[i][j-1])
					mat[i][j] = mat[i][j-1];
				else
					mat[i][j] = mat[i-1][j];
			}
		return mat;
	}

	void getString(String s1, int[][] mat, int i, int j, StringBuffer sb){
		if(i==0 || j==0)
			return;
		if(mat[i][j]>mat[i-1][j-1] && mat[i][j]>mat[i][j-1] && mat[i][j]>mat[i-1][j]){
			getString(s1, mat, i-1, j-1, sb);
			sb.append(s1.charAt(i-1));
		}else if(mat[i][j]==mat[i-1][j]){
			getString(s1, mat, i-1, j, sb);
		}else{
			getString(s1, mat, i, j-1, sb);
		}
	}

	String LCS(String s1, String s2){
		if(s1==null || s2==null)
			return null;
		int[][] mat = generateMatrix(s1, s2);
		StringBuffer sb = new StringBuffer();
		getString(s1, mat, s1.length(), s2.length(), sb);
		return sb.toString();
	}
