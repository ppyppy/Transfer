	void Shuffle(int[] cards){
		if(cards==null || cards.length<2)
			return;
		for(int i=0; i<cards.length; i++){
			int index = (int) (Math.random()*(cards.length-i))+ i;
			int temp = cards[index];
			cards[index] = cards[i];
			cards[i] = temp;
		}
	}