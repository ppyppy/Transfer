String RemoveDuplicates(char[] chs){
	if(chs==null || chs.length<=1)
		return new String(chs);
	int tail = 1;
	for(int i=1; i<chs.length; i++){
		int j=0;
		for( ; j<tail; j++){
			if(chs[i]==chs[j])
				break;
		}
		if(j==tail){ //no duplicate found
			chs[tail] = chs[i];
			tail++;
		}
	}
	return new String(chs).substring(0, tail);
}