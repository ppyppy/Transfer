////  1=>2=>7=>8
//       |
//       3=>4=>6
//          |
//          5
//flatten sequence 1, 2, 3, 4, 5, 6, 7, 8

Node flatter1(Node node){
	if(node==null)
		return null;
	Stack<Node> stack = new Stack<Node>();
	Node head = node;
	while(node.next!=null || node.clild!=null || !stack.isEmpty()){
		if(node.next==null && node.clild==null)
			node.next = stack.pop();
		if(node.child!=null){
			if(node.next!=null){
				stack.push(node.next);
			}
			node.next = node.child;
			node.child = null;
		}
		node = node.next;
	}
	return head;
}

//flatten sequence 1, 2, 7, 8, 3, 4, 6, 5
Node flatter2(Node node){
	if(node==null)
		return null;
	Node tail = node;
	while(tail.next!=null)
		tail = tail.next;
	Node cur = node;
	while(cur!=null){
		if(cur.child!=null){
			tail.next = cur.child;
			cur.child = null;
			while(tail.next!=null)
				tail = tail.next;
		}
		cur = cur.next;
	}
	return node;
}