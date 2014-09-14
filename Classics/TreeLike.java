
boolean TreeLike(TreeNode T1, TreeNode T2){
	if(T1==null && T2==null)
		return true;
	if(T1==null || T2==null)
		return false;
	return TreeLike(T1.left, T2.left) && TreeLike(T1.right, T2.right);
}