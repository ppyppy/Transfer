int layerLevelTraverser(TreeNode T){
	if(T==null)
		return 0;
	LinkedList<TreeNode> queue = LinkedList<TreeNode>();
	queue.addFirst(T);
	TreeNode node;
	while(!queue.isEmpty()){
		TreeNode node = queue.removeLast();
		if(node.left!=null){
			node.left.level = node.level+1;
			queue.addFirst(node.left);
		}
		if(node.right!=null){
			node.right.level = node.level+1;
			queue.addFirst(node.right);
		}
	}
	return node.level;
}

int layerLevelTraverser(TreeNode T){
	if(T==null)
		return 0;
	TreeNode[] Q = new TreeNode[100]; //size is the total Tree's node
	int front=-1, rear=-1, last=-1, level=-1, width=0, max=0; //tree's maximum width
	Q[++rear] = T;
	last = rear;
	while(front<rear){
		TreeNode node = Q[++front];
		width++;
		if(node.left!=null)
			Q[++rear] = node.left;
		if(node.right!=null)
			Q[++rear] = node.right;
		if(front==last){
			last = rear;
			level++;
			if(width>max){
				max = width;
				width = 0;
			}
		}
	}
	return level;
}