//Given an NxN matrix of positive and negative integers, write code to find the submatrix
//with the largest possible sum.

int maxSubMatrix(int[][] mat){
	if(mat==null || mat.length==0)
		return 0;
	int row = mat.length;
	int col = mat[0].length;
	int[] colSum = new int[col];
	int max = 0;
	for(int rs=0; rs<row; rs++){
		clearArray(colSum);
		for(int re=rs; re<row; re++){
			for(int j=0; j<col; j++){
				colSum[j] += mat[re][j];
			}
			int tempMax = maxArray(colSum);
			if(tempMax>max)
				max = tempMax;
		}
	}
	return max;
}