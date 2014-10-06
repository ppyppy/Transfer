boolean isBST(TreeNode T, int low, int high){
	if(T==null)
		return true;
	if(low<T.val && T.val<high){
		return isBST(T.left, low, T.val) && isBST(T.right, T.val, high);
	}else{
		return false;
	}
}