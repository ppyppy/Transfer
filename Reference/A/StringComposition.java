////有一种String,是把一个更短的String重复n次而构成的，那个更短的String长度至少为
//，输入一个String写代码返回T或者F
//例子：
//"abcabcabc"  Ture   因为它把abc重复3次构成
//"bcdbcdbcde" False  最后一个是bcde
//"abcdabcd"   True   因为它是abcd重复2次构成
//"xyz"       False  因为它不是某一个String重复
//"aaaaaaaaaa"  False  重复的短String长度应至少为2（这里不能看做aa重复5次)
//
//要求算法复杂度为O(n)


	public boolean isMultiple(String s) {
		if(s==null || s.length()==0)
			return true;
		int maxInterval = 1;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] chs = s.toCharArray();
		for(int i=0; i<chs.length; i++){
			if(!map.containsKey(chs[i]))
				map.put(chs[i], i);
			else{
				int pre = map.get(chs[i]);
				if(maxInterval<(i-pre)){
					maxInterval = i-pre;
				}
				map.put(chs[i], i);
			}
		}
		int length = chs.length;
		if(maxInterval==1){
			if(length%2==0 && length/2>1)
				return true;
			for(int i=3; i*i<=length; i+=2){
				if(length%i==0 && length/i>1)
					return true;
			}
			return false;
		}
		if(length%maxInterval!=0)
			return false;
		List<String> list = new ArrayList<String>();
		for(int i=0; i<length; i+=maxInterval)
			list.add(s.substring(i, i+maxInterval));
		if(list.size()==1)
			return false;
		String pre = list.get(0);
		for(String str : list){
			if(!pre.equals(str))
				return false;
		}
		return true;
	}
	
Test case:

"abcabcabcab" // false

"bcdbcdbcde" //false

"abcdabcd" //true

"xyzxy" //false

"aaaaaaaaaaaaaaaaaaaaa" //true

"bcdbcdbcdbcdbcdbc" //fasle

"aaaaabaaaa" //false



bcdbcdbcdebcdbcdbcde //true

