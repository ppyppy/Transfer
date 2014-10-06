//10 8 9 12 11 13		(pre
//8 9 10 11 12 13		(in
//9, 8, 11, 13, 12, 10 (post
//		10
//	8		12
//	  9   11   13

TreeNode preInorderToTree(int[] pre, int[] post, int i, int j, int len){
	if(len<=0 || pre==null || post==null)
		return null;
	TreeNode T = new TreeNode(pre[i]);
	int m = posInOrder(pre[i], post);
	//pay attention that m only related to j in the Inorder, lenth can only start from (m-j)
	T.left = preInorderToTree(pre, post, i+1, j, m-j);
	T.right = preInorderToTree(pre, post, i+(m-j)+1, m+1, len-(m-j)-1);  
	return T;
}

TreeNode postInorderToTree(int[] post, int[] in, int i, int j, int len){
	if(len<=0 || post==null || in==null)
		return null;
	TreeNode T = new TreeNode(post[i]);
	int m = posInOrder(post[i], in);
	//pay attention that m only related to j in the Inorder, lenth can only start from (m-j)
	T.right = postInorderToTree(post, in, i-1, m+1, len-(m-j)-1);
	T.left = postInorderToTree(post, in, i-(len-(m-j)-1)-1, j, m-j);
	return T;
}

int posInOrder(int val, int[] post){
	for(int i=0; i<post.length; i++){
		if(val==post[i])
			return i;
	}
	throw new RuntimeException("value not found in post");
}