////////////////////////////
//Q						///
//		Q				///
//				Q		///
//						///
//	Q					///
//					Q	///
//						///
//			Q			///
////////////////////////////
ArrayList<String[]> solveNQueens(int n){
	ArrayList<String[]> lists = new ArrayList<String[]>();
	int[] columnForRow = new int[n];
	solveNQueens(columnForRow, 0, n, lists);
	return lists;
}

void solveNQueens(int[] columnForRow, int curRow, int n, ArrayList<String[]> lists){
	if(curRow==n){
		char[] chs = new char[n];
		String[] list = new String[n];
		for(int i=0; i<n; i++){
			Arrays.fill(chs, '.');
			chs[columnForRow[i]] = 'Q';
			list[i] = new String(chs);
		}
		lists.add(list);
		return;
	}
	for(int j=0; j<n; j++){
		columnForRow[curRow] = j;
		if(isQueen(columnForRow, curRow)==true){
			solveNQueens(columnForRow, curRow+1, n, lists);
		}
	}
}

boolean isQueen(int[] columnForRow, int curRow){
	for(int i=0; i<curRow; i++){
		int diff = Math.abs(columnForRow[i] - columnForRow[curRow]);
		if(diff==0 || diff==(curRow-i)) //same column for diagonal
			return false;
	}
	return true;
}