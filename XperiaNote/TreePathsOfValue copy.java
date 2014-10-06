// get all paths of binary tree which sums to a value. (from root to leave)
void getPaths(TreeNode T, int sum, LinkedList<TreeNode> s, int current){
	if(T==null)
		return;
	current += T.val;
	s.addFirst(T);
	if(T.left!=null)
		getPaths(T.left, sum, s, current);
	if(T.right!=null)
		getPaths(T.right, sum, s, current);
	if(T.left==null && T.right==null)
		if(current==sum){
			LinkedList<TreeNode> sCopy = (LinkedList<TreeNode>)s.clone();
			while(!sCopy.isEmpty()){
				System.out.print(sCopy.removeFirst() + ",");
			}
			System.out.println();
		}
	s.removeFirst(); //exit the function, delete current node
}