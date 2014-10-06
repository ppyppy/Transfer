//30 10 50 # # # 20 45 # # 35 # #
//
//		    30
//	  10		20
//50		45		35

void serializeTree(TreeNode T, StringBuffer sb){
	if(T==null){
		sb.append("#");
		return;
	}
	sb.append(T.val);
	serializeTree(T.left, sb);
	serializeTree(T.right, sb);
}

int count = 0; //must be outside, always get next, no dependent on recursion
TreeNode deSerializeTree(char[] chs){
	if(chs==null || count>=chs.length)
		return null;
	if(chs[count]=='#'){
		count++;
		return null;
	}
	TreeNode T = new TreeNode(chs[count++]-'0');
	T.left = deSerializeTree(chs);
	T.right = deSerializeTree(chs);
	return T;
}