//recursive
ArrayList<String> getSubSets(String s){
	ArrayList<String> list = new ArrayList<String>();
	if(s==null || s.length()==0)
		return list;
	if(s.length()==1){
		list.add(s)
		return list;
	}
	char first = s.charAt(0);
	String remain = s.substring(1);
	list.add(first);
	for(String word : getSubSets(remain)){
		list.add(word);
		list.add(first+word);
	}
	return list;
}

//Bit Manipulation (Best)
ArrayList<String> getSubSets(String s) {
	ArrayList<String> list = new ArrayList<String>();
	if (s == null || s.length() == 0)
		return list;
	char[] chs = s.toCharArray();
	int val = 0;
	for (int i = 0; i < chs.length; i++) {
		val += (1 << i);
	}
	for (int k = 1; k <= val; k++) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < chs.length; i++) {
			if ((k & (1 << i)) > 0)
				sb.append(chs[i]);
		}
		list.add(sb.toString());
	}
	return list;
}

//Iterator and Recursive
ArrayList<String> getSubSets(String s) {
	ArrayList<String> list = new ArrayList<String>();
	if (s == null || s.length() == 0)
		return list;
	char[] chs = s.toCharArray();
	subSetsHelper(chs, new StringBuilder(), 0, list);
	return list;
}

void subSetsHelper(char[] chs, StringBuilder sb, int start, ArrayList<String> list){
	for(int i=start; i<chs.length; i++){
		sb.append(chs[i]);
		list.add(sb.toString());
		subSetsHelper(chs, sb, i+1, list);
		sb.setLength(sb.length()-1);
	}
}

