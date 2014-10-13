// DFS level print tree

void printLevelOrder(TreeNode T){
	int height = getTreeHeight(T);
	for(int level=1; i<=height; i++)
		printLevel(T, level);
}

void printLevel(TreeNode T, int level){
	if(T==null)
		return;
	if(level==1)
		System.out.print(T.val);
	else{
		printLevel(T.left, level-1);
		printLevel(T.right, level-1);
	}
}