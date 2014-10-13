//Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
//
//For example,
//Given:
//s1 = "aabcc",
//s2 = "dbbca",
//
//When s3 = "aadbbcbcac", return true.
//When s3 = "aadbbbaccc", return false.

	    public boolean isInterleave(String s1, String s2, String s3) {
	        if(s3==null && (s1!=null || s2!=null))
	        	return false;
	        if( s3.length() != (s1.length() + s2.length()) )
	        	return false;
	        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
	        boolean[][] mat = new boolean[len1+1][len2+1];
	        mat[0][0] = true;
	        for(int i=1; i<mat.length; i++){
	        	mat[i][0] = ( mat[i-1][0] && (s1.charAt(i-1)==s3.charAt(i-1)) );
	        }
	        for(int j=1; j<mat[0].length; j++){
	        	mat[0][j] = ( mat[0][j-1] && (s2.charAt(j-1)==s3.charAt(j-1)) );
	        }
	        for(int i=1; i<mat.length; i++)
	        	for(int j=1; j<mat[0].length; j++){
	        		mat[i][j] = ( mat[i-1][j] && (s1.charAt(i-1)==s3.charAt(i+j-1)) ) 
	        					|| ( mat[i][j-1] && (s2.charAt(j-1)==s3.charAt(i+j-1)) );
	        	}
	        return mat[len1][len2];
	    }