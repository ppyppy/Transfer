//Find all paths which sum up to the value. Any paht in the tree, can start from middle node;

void findSum(TreeNode T, int sum, ArrayList<Integer> buffer, int level){
	if(T==null)
		return;
	buffer.add(T.val);
	int total = sum;
	for(int i=level; i>=0; i--){
		total -= buffer.get(i);
		if(total==0)
			print(i, level, buffer);
	}
	ArrayList<Integer> buffer1 = (ArrayList<Integer>)buffer.clone();
	ArrayList<Integer> buffer2 = (ArrayList<Integer>)buffer.clone();
	findSum(T.left, sum, buffer1, level+1);
	findSum(T.right, sum, buffer2, level+1);
}