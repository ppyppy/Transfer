// Bottom up approach. Convert Sorted LinkedList to BST


 LinkedList<Integer> head = null;
 
 TreeNode sortedListToBST(LinkedList<Integer> start){
	 if(start==null)
		 return null;
	 head = start;
	 int length = start.size();
	 return sortedListToBST(0, length-1);
 }
 
 TreeNode sortedListToBST(int low, int high){
	 if(low>high)
		 return null;
	 int mid = (low + high)/2;
	 TreeNode left = sortedListToBST(low, mid-1);
	 
	 TreeNode root = new TreeNode(head.removeFirst());//assign first val, head = head.next;
	 
	 TreeNode right = sortedListToBST(mid+1, high);
	 
	 root.left = left; root.right = right;
	 return root;
 }