// RGGB with YRGB, B is hit and G is pseudo hit

void checkHits(String s1, String s2){
	int mask = 0; //int is 32 bit, but only has 26 characters
	for(int i=0; i<s1.length(); i++){
		mask |= 1<<(s2.charAt(i)-'A');
	}
	for(int i=0; i<s1.length(); i++){
		if(s1.charAt(i)==s2.charAt(i))
			System.out.println("Hit");
		else if( mask&(1<<(s1.charAt(i)-'A')) > 0 )
			System.out.println("pseudo Hit");
	}
}