	int makeChange(int money, int changeValue){ //changeValue is the current value to change
		int nextValue = 0;
		switch(changeValue){
			case 25:
				nextValue = 10;
				break;
			case 10:
				nextValue = 5;
				break;
			case 5:
				nextValue = 1;
				break;
			case 1:
				return 1;
		}
		int ways = 0;
		for(int i=0; i*changeValue<=money; i++){
			ways += makeChange(money-i*changeValue, nextValue);
		}
		return ways;
	}