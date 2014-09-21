boolean isBalancedTree(TreeNode T){
		return ( maxDepth(T)-minDepth(T) )<=1;
}

int maxDepth(TreeNode T){
	if(T==null)
		return 0;
	return Math.max(maxDepth(T.left), maxDepth(T.right))+1;
}

int minDepth(TreeNode T){
	if(T==null)
		return 0;
	return Math.min(minDepth(T.left), minDepth(T.right))+1;
}