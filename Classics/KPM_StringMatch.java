// 0 1 2 3 4 5 6 7
// a b a a b c a c
//-1 0 0 1 1 2 0 1

//a c a b
//a b -> next[1]=0

//a c a b
//  a -> next[0]=-1 (i++, j++ => i=2, j=0)

//a c a b a a b a a b...
//    a b a a b c -> next[5]=2

//a c a b a a b a a b...
//          a b a a b...

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