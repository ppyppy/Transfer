//A Cartesian tree is a binary tree derived from a sequence of numbers;
//It is heap-ordered and that a symmetric (in-order) traversal of the tree returns the original sequence.

/*
9	3	7	1	8	12	10	20	15	18	5

            1
    3									5
9		7		8
						10
					12			15
							20		18
*/

/////Recursive, O(lgn*n)
TreeNode buildCartesianTree(int[] num){
	if(num==null || num.length==0)
		return null;
	return build(num, 0, num.length-1);
}

TreeNode build(int[] num, int start, int end){
	if(start>end)
		return null;
	int min = Integer.MAX_VALUE, index = 0;
	for(int i=start; i<=end; i++){
		if(num[i]<min){
			min = num[i];
			index = i;
		}
	}
	TreeNode T = new TreeNode(num[index]);
	T.left = build(num, start, index-1);
	T.right = build(num, index+1, end);
	return T;
}

//Iterative, O(n)
TreeNode buildCartesianTree(int[] num){
	if(num==null || num.length==0)
		return null;
	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
	TreeNode parent = null, T = null;
	for(int i=0; i<num.length; i++){
		TreeNode p = new TreeNode(num[i]);
		while(!stack.isEmpty() && stack.getFirst().val>num[i]){
			parent = stack.removeFirst();  //parent, last one that bigger than num[i]
		}
		if(stack.isEmpty()){
			p.left = parent;
			T = p;
		}else{
			stack.getFirst().right = p;
			p.left = parent;
		}
		stack.addFirst(p);
		parent = null;
	}
	return T;
}


