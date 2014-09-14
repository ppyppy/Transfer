void PreOrderTraverse(TreeNode T){
	if(T==null)
		return;
	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
	stack.addFirst(T);
	while(!stack.isEmpty()){
		TreeNode node = stack.removeFirst();
		System.out.print(node.val);
		if(node.right!=null)
			stack.addFirst(node.right);
		if(node.left!=null)
			stack.addFirst(node.left);
	}
}

void InOrderTraverse(TreeNode T){
	if(T==null)
		return;
	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
	stack.addFirst(T);
	while(!stack.isEmpty()){
		TreeNode node = stack.getFirst();
		while(node!=null){
			stack.addFirst(node.left);
			node = node.left;
		}
		stack.removeFirst();
		if(!stack.isEmpty()){
			TreeNode p = stack.removeFirst();
			System.out.print(p.val);
			stack.addFirst(p.right);
		}
	}
}

void postOrderTraverse(TreeNode T){
	if(T==null)
		return;
	LinkedList<TreeNode> in = new LinkedList<TreeNode>();
	LinkedList<TreeNode> out = new LinkedList<TreeNode>();
	in.addFirst(T);
	while(!in.isEmpty()){
		TreeNode node = in.removeFirst();
		out.addFirst(node);
		if(node.left!=null)
			in.addFirst(node.left);
		if(node.right!=null)
			in.addFirst(node.right);
	}
	while(!out.isEmpty()){
		System.out.print(out.removeFirst().val);
	}
}