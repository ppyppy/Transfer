
//写一个函数生成满足下面三个条件的integer
//1. 非负
//2. 不能有重复数字
//3. 递增，既后面产生的比前面产生的要大
//
//我问要一次性全部生成所有数字还是每呼叫一次函数产生一个，他让我先写一次性产生
//全部的，这个不难，backtracking，follow up是假设现在给一个符合条件的数字，如
//789，返回下一个（比输入大但是最小的）数字，790。一开始我没思路，说很多edge 
//case，然后多观察几个例子后发现有些规律，说出来后他说看起来不错，然后举了几个
//例子让我模拟跑一遍，没有问题，他说ok，不用写code了，正好也到时间了
String next(char[] chs)
	    {
	    	if(chs==null || chs.length==0)
	    		return "0";
	    	if(chs[0]=='-')
	    		return "0";
	    	HashSet<Character> set = new HashSet<Character>();
	    	for(char ch : chs){
	    		set.add(ch);
	    	}
	    	int i = chs.length-1;
	    	for(; i>=0; i--){
	    		int val = (chs[i]-'0')+1;
	    		set.remove(chs[i]);
	    		int k=val;
	    		for(; k<=9; k++){
	    			if(!set.contains((char)('0'+k))){
	    				chs[i] = (char) ('0'+k);
	    				set.add(chs[i]);
	    				break;
	    			}
	    		}
	    		if(k<=9)
	    			break;
	    	}
	    	if(i==-1){
	    		chs = new char[chs.length+1];
	    		chs[0] = '1';
	    		set.add(chs[0]);
	    		i = 0;
	    	}	
			for(int index=i+1; index<chs.length; index++){
				int ii=0;
				for(; ii<=9; ii++){
					if(!set.contains((char)('0'+ii))){
						chs[index] = (char) (ii+'0');
						set.add(chs[index]);
						break;
					}
				}
				if(ii>9)
					throw new RuntimeException("has repeated number!");
			}
			return new String(chs);
	    }