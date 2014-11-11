//Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, 
//write a method to rotate the image by 90 degrees. Can you do this in place?


//counter clock wise
	void rotateMatrix(int[][] mat) {
		if (mat == null || mat.length == 0)
			return;
		int m = mat.length, n = mat[0].length;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				if (j>i) {
					mat[i][j] = mat[i][j]^mat[j][i];
					mat[j][i] = mat[i][j]^mat[j][i];
					mat[i][j] = mat[i][j]^mat[j][i];
				}
			}
		for(int i=0; i<(m/2); i++){
			swap(mat[i], mat[m-1-i]);
		}
	}
	
	void swap(int[] m1, int[] m2){
		for(int i=0; i<m1.length; i++){
			m1[i] = m1[i]^m2[i];
			m2[i] = m1[i]^m2[i];
			m1[i] = m1[i]^m2[i];
		}
	}
	
//clock wise
	void rotateMatrix(int[][] mat) {
		if (mat == null || mat.length == 0)
			return;
		int m = mat.length, n = mat[0].length;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				if (j>i) {
					mat[i][j] = mat[i][j]^mat[j][i];
					mat[j][i] = mat[i][j]^mat[j][i];
					mat[i][j] = mat[i][j]^mat[j][i];
				}
			}
		for(int i=0; i<m; i++)
			for(int j=0; j<(n/2); j++){
				mat[i][j] = mat[i][j] ^ mat[i][n-1-j];
				mat[i][n-1-j] = mat[i][j] ^ mat[i][n-1-j];
				mat[i][j] = mat[i][j] ^ mat[i][n-1-j];
			}
	}
	