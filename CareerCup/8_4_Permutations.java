//recursive
ArrayList<String> getPermutations(String s){
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
		for(int i=0; i<=word.length(); i++){
			list.add(insertAt(i, first, word));
		}
	}
	return list;
}

String insertAt(int index, char ch, String s){
	if(s==null)
		return s;
	String start = s.substring(0, index);
	String end = s.substring(index);
	return new StringBuilder().append(start).append(ch).append(end);
}

//Iterator and Recursive
ArrayList<String> getPermutations(String s) {
	ArrayList<String> list = new ArrayList<String>();
	if (s == null || s.length() == 0)
		return list;
	char[] chs = s.toCharArray();
	boolean[] tags = new boolean[chs.length];
	permutationsHelper(chs, new StringBuilder(), 0, list, tags);
	return list;
}

void permutationsHelper(char[] chs, StringBuilder sb, int index, ArrayList<String> list, boolean[] tags){
	if(index==chs.length){
		list.add(sb.toString());
		return;
	}
	for(int i=0; i<chs.length; i++){
		if(tags[i]==false){
			tags[i] = true;
			sb.append(chs[i]);
			permutationsHelper(chs, sb, index+1, list, tags);
			tags[i] = false;
			sb.setLength(sb.length()-1);
		}
	}
}

