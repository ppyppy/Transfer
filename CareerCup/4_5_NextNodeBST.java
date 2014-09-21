//Find next node (inorder) of a given node in BST, where each node has a link to its parent.

public TreeNode InorderNext(TreeNode T){
	if(T==null)
		return;
	TreeNode parent;
	if(T.parent==null || T.right!=null){
		return leftMost(T.right);
	}
	parent = T.parent;
	while(parent!=null){
		if(parent.left==T)
			break;
		T = parent;
		parent = T.parent;		
	}
	return parent;
}

public TreeNode leftMost(TreeNode node){
	if(node==null)
		return null;
	while(node.left!=null)
		node = node.left;
	return node;
}