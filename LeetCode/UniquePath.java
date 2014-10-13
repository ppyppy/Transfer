//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

//The robot can only move either down or right at any point in time. The robot is trying to reach the 
//bottom-right corner of the grid (marked 'Finish' in the diagram below).

//How many possible unique paths are there?

public int uniquePaths(int m, int n) {
        if(m==0 || n==0)
            return 0;
        int[][] mat = new int[m][n];
        for(int j=0; j<n; j++)
            mat[0][j] = 1;
        for(int i=0; i<m; i++)
            mat[i][0] = 1;
        for(int i=1; i<m; i++)
            for(int j=1; j<n; j++){
                mat[i][j] = mat[i-1][j] + mat[i][j-1];
            }
        return mat[m-1][n-1];
    }