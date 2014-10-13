// 1 1 1
// 1 2 3
// 1 3 6
//if have obstacle on some path, set as 0
// 0 0 0   1 1 1
// 0 1 0   1 0 1
// 0 0 0   1 1 2
//

//minimum sum
//
// 1 3 1      1 4 5
// 1 5 1  =>  2 7 6
// 4 2 1      6 8 7

int UniquePaths(int m, int n){
	int[][] mat = new int[m][n];
	for(int i=0; i<m; i++)
		for(int j=0; j<n; j++){
			mat[i][j] = 1;
		}
	for(int i=1; i<m; i++)
		for(int j=1; j<n; j++){	
			mat[i][j] = mat[i-1][j] + mat[i][j-1];
		}
	return mat[m-1][n-1];
}