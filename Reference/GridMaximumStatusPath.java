//假设你是harry potter，在grid的左上角，你现在要走到右下角，grid中有
//正数也有负数，遇到正数表示你的strength增加那么多，遇到负数表示strength减少那
//么多，在任何时刻如果你的strength小于等于0，那么你就挂了。在一开始你有一定的
//初始的strength，现在问这个初始的strength最少是多少，才能保证你能够找到一条路
//走到右下角

	int max = Integer.MIN_VALUE;
	void getLeastEneryHelper(int[][] mat, int x, int y, int cur_val, int cur_min){
		if(cur_val<cur_min)
			cur_min = cur_val;
		if( (x>=mat.length-1 && y>=mat[0].length-1) || cur_min<=max){
			if(cur_min>max)
				max = cur_min;
			return;
		}
		if(x<mat.length-1)
			getLeastEneryHelper(mat, x+1, y, cur_val+mat[x+1][y], cur_min);
		if(y<mat[0].length-1)
			getLeastEneryHelper(mat, x, y+1, cur_val+mat[x][y+1], cur_min);
	}

	int getLeastEnery(int[][] mat){
		if(mat==null || mat.length==0)
			return 0;
		getLeastEneryHelper(mat, 0, 0, 0, Integer.MAX_VALUE);
		return max;
	}
	
	int[][] mat = {{0, -1, 1, -2},
			   {-2, 0, -1, 9},
			   {1, -2, 1, 7},
			   {5, 3, 4, 1}};
	Solution s = new Solution();
	s.getLeastEnery(mat);