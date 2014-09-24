int shortDistance(String[] words, String w1, String w2){
	int index1 = -Integer.MAX_VALUE/2;
	int index2 = -Integer.MAX_VALUE/2;
	int distance = Integer.MAX_VALUE;
	for(int i=0; i<words.length; i++){
		if(w1.equals(words[i])){
			index1 = i;
			if( (index1-index2)<distance )
				distance = index1-index2;
		}else if(w2.equals(words[i])){
			index2 = i;
			if( (index2-index1)<distance )
				distance = index2-index1;
		}
	}
	return distance;
}