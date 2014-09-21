//Sort stack in ascending, only use push\pop\peek operations.

//1// 
//3//
//2//
/////
//become
//3//
//2//
//1//
/////  

Stack<Integer> sort(Stack<Integer> s){
	if(s==null)
		return null;
	Stack<Integer> s1 = new Stack<Integer>();
	while(!s.isEmpty()){
		int value = s.pop();
		while(!s1.isEmpty() && s1.peek()>value){
			s.push(s1.pop());
		}
		s1.push(value);
	}
	return s1;
}