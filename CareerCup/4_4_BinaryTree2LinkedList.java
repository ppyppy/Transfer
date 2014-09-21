//to linkedlist by layer
ArrayList<LinkedList<TreeNode>> tree2LinkedListByLayer(TreeNode T){
	if(T==null)
		return null;
	ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
	tree2LinkedListHelper(T, 0, lists);
	return lists;
}

void tree2LinkedListHelper(TreeNode T, int level, ArrayList<LinkedList<TreeNode>> lists){  //preorder traverse, add node by level
	if(T==null)
		return;
	if(level>=lists.size())
		lists.add(new LinkedList<TreeNode>());
	lists.get(level).add(T);
	tree2LinkedListHelper(T.left, level+1, lists);
	tree2LinkedListHelper(T.right, level+1, lists);
}