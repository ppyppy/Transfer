
private TreeNode retNode; 

boolean SearchBST(TreeNode T, int key, TreeNode parent){
	if(T==null){//not able to find
		retNode = parent;
		return false;
	}else if(T.val==key){
		retNode = T;
		return true;
	}else if(T.val>key){
		return SearchBST(T.left, key, T);
	}else{
		return SearchBST(T.right, key, T);
	}
}

boolean InsertBST(TreeNode T, int value){
	if(!SearchBST(T, value, null)){
		if(retNode==null){
			retNode = new TreeNode(value);
		}else if(retNode.val>value){
			TreeNode newNode = new TreeNode(value);
			retNode.left = newNode;
		}else{
			TreeNode newNode = new TreeNode(value);
			retNode.right = newNode;
		}
		return true;
	}
	return false;
}
