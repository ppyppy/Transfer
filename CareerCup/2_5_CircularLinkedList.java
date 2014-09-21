        \\\\\0
             \  \ k
       n-k  \     \
            \    \
               \
////////////From start of the circle///////////               
//First node:  n1=0  to n-k
//Second node: n2=k  to 2(n-k)+k=2n-k
//So n2-n1=2n-k-(n-k)=n
           
////////////From start///////////
//First Node:  k  (0 steps from circle)
//Second Node: 2k (k steps from circle)
               
        LinkedListNode findBeginningOfCircle(LinkedListNode head){
        	if(head==null)
        		return null;
        	LinkedListNode n1=head, n2=head;
        	//get meeting point
        	while(n2!=null && n2.next!=null){
        		n1 = n1.next;
        		n2 = n2.next.next;
        		if(n1==n2)
        			break;
        	}
        	if(n1!=n2 || n2==null) //not meet, no circle
        		return null;
        	n1=head;
        	while(n1!=n2){  //n1 back to head, step k to find first node of circle
        		n1 = n1.next;
        		n2 = n2.next;
        	}
        	return n1;
        }