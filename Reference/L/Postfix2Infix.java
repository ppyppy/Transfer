//a,b,+,c,/  ==>  ((a+b)/c)

class FixNode{
	fixNode pre;
	fixNode next;
	char ch;
	public FixNode(char val, fixNode p, fixNode n){
		ch = va;
		pre = p;
		next = n;
	}
}

String Postfix2Infix(String str){
	Stack<FixNode> stack = new Stack<FixNode>();
	for(char ch : str.toCharArray()){
		if( (ch>='a'&&ch<='z') || (ch>='A'&&ch<='Z') ){
			FixNode node = new FixNode(ch, null, null);
			stack.push(node);
		}else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
			if(stack.size()<2){
				throw new RuntimeException("not valid!");
			}
			FixNode nextNode = stack.pop();
			FixNode preNode = stack.pop();
			FixNode curNode = new FixNode(ch, preNode, nextNode);
			stack.push(curNode);
		}
	}
	StringBuffer sb = new StringBuffer();
	generateInfix(stack.pop(), sb);
	return sb.toString();
}

int cc = 0;

void generateInfix(FixNode node, StringBuffer sb){
	if(node==null){
		return;
	}
	generateInfix(node.pre, sb);
	sb.append(node.ch);
	cc++;
	if( cc>=3 && (cc&0x01)>0 ){  //first 3 elements, than every 2 elements
		sb.insert(0, '(');
		sb.append(')');
	}
	generateInfix(node.next, sb);
}