//Decide T2 is a subtree of T1

boolean isSubTree(TreeNode T1, TreeNode T2){
	if(T1==null)
		return false;
	if(T2==null)
		return true;
	if(T1.val==T2.val)
		if(isMatchTree(T1, T2))
			return true;
	return isSubTree(T1.left, T2) || isSubTree(T1.right, T2);
}

boolean isMatchTree(TreeNode T1, TreeNode T2){
	if(T1==null && T2==null)
		return true;
	if(T1==null || T2==null)
		return false;
	if(T1.val!=T2.val)
		return false;
	return isMatchTree(T1.left, T2.left) && isMatchTree(T1.right, T2.right);
}