
 TreeNode BinarySearchTreeCommonAncestor(TreeNode T, TreeNode left, TreeNode right){
	if(T==null)
		return null;
	if(left==null || right==null)
		return left!=null ? left : right;
	while(T!=null){
		if(T.val<left.val && T.val<right.val){
			T = T.right;
		}else if(T.val>left.val && T.val>right.val){
			T = T.left;
		}else{
			return T;
		}
	}
	return null;
}

 TreeNode CommonAncestor(TreeNode T, TreeNode p, TreeNode q){
	 if(T==null)
		 return null;
	 if(p==null || q==null)
		return p!=null ? p : q;
	 if(T==p || T==q)
		 return T;
	 TreeNode L = CommonAncestor(T.left, p, q);
	 TreeNode R = CommonAncestor(T.right, p, q);
	 if(L!=null && R!=null)
		 return T;
	 return L!=null ? L : R;
 }