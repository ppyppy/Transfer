	ArrayList<String> generateParentheses(int n){
		ArrayList<String> list = new ArrayList<String>();
		if(n<1)
			return list;
		char[] chs = new char[2*n];
		parenthesesHelper(n, n, chs, 0, list);
		return list;
	}

	void parenthesesHelper(int left, int right, char[] chs, int index, ArrayList<String> list){
		if(left==0 && right==0){
			list.add(new String(chs));
			return;
		}
		if(left>right)
			return;
		if(left>0){
			chs[index] = '(';
			parenthesesHelper(left-1, right, chs, index+1, list);
		}
		if(right>left){
			chs[index] = ')';
			parenthesesHelper(left, right-1, chs, index+1, list);
		}
	}