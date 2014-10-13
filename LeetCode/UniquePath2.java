//Follow up for "Unique Paths":
//
//Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
//An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
//For example,
//There is one obstacle in the middle of a 3x3 grid as illustrated below.
//
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null)
            return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] mat = new int[m][n];
        for(int j=0; j<n; j++){
            if(obstacleGrid[0][j]==1)
                break;
            mat[0][j] = 1;
        }
        for(int i=0; i<m; i++){
            if(obstacleGrid[i][0]==1)
                break;
            mat[i][0] = 1;
        }
        for(int i=1; i<m; i++)
            for(int j=1; j<n; j++){
                if(obstacleGrid[i][j]==1)
                    continue;
                mat[i][j] = mat[i-1][j] + mat[i][j-1];
            }
        return mat[m-1][n-1];
    }