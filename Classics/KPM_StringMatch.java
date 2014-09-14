	void generateNext(String s, int[] next) {
		if (s == null || s.length() == 0)
			return;
		int i = 0, j = -1;
		next[0] = -1;
		while (i < s.length() - 1) {
			if (j == -1 || s.charAt(i) == s.charAt(j)) {
				i++;
				j++;
				next[i] = j;
			} else {
				j = next[j];
			}
		}
	}
	
	int index_KMP(String s, String t, int[] next){
		if(t==null)
			return 0;
		if(s==null || s.length()<t.length())
			return -1;
		int i=0, j=0;
		while(i<s.length() && j<t.length()){
			if(j==-1 || s.charAt(i)==t.charAt(j)){
				i++; j++;
			}else{
				j = next[j];
			}
		}
		if(j>=t.length())
			return i-t.length();
		return -1;
	}