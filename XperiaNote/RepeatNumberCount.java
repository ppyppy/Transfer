// Repeated numbers count
// Bookkeepers are cool: 4
// aa.aa 1
// programming is so ordinary 3

	    int repeatedCount(String str){
	    	if(str==null || str.length()==0)
	    		return 0;
	    	ArrayList<Character> list = new ArrayList<Character>();
	    	for(int i=0; i<str.length(); i++)
	    		if(str.charAt(i)>='a' && str.charAt(i)<='z')
	    			list.add(str.charAt(i));
	    	int count = 0, sum = 0;
	    	char pre = ' ';
	    	for(char ch : list){
	    		if(pre!=ch)
	    			count = 0;
	    		else if(pre==ch){
	    			if(count==0)
	    				sum++;
	    			count++;
	    		}
	    		pre = ch;
	    	}
	    	return sum;
	    }