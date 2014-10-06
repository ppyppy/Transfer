void PrintTelephoneWords(int[] phoneNum){
	char[] ret = new char[phoneNum.length];
	PrintTelephoneWords(phoneNum, 0, ret);
}

void PrintTelephoneWords(int[] num, int index, char[] result){
	if(index==result.length){
		System.out.println(result);
		return;
	}
	for(int i=0; i<3; i++){
		result[index] = getChar(num[index], i);
		PrintTelephoneWords(num, index+1, result);
		if(num[index]==0 || num[index]==1)
			break;
	}
}

////////////////Iterative solution////////////////////
void PrintTelephoneWords(int[] phoneNum){
	char[] result = new char[phoneNum.length];
	for(int i=0; i<result.length; i++)
		result[i] = getChar(phoneNum[i], 0);
	while(true){
		System.out.println(result);
		for(int i=result.length-1; i>=-1; i--){
			if(i==-1)
				return;
			if(result[i]==getChar(phoneNum[i], 2) || phoneNum[i]==0 || phoneNum[i]==1)
				result[i] = getChar(phoneNum[i], 0);
			else if(result[i]==getChar(phoneNum[i], 0)){
				result[i] = getChar(phoneNum[i], 1);
				break;
			}else if(result[i]==getChar(phoneNum[i], 1)){
				result[i] = getChar(phoneNum[i], 2);
				break;
			}
		}
	}
}

char getChar(int num, int index){
	char ret = ' ';
	switch (num){
		case 2:
			if(index==0)
				ret = 'a';
			if(index==1)
				ret = 'b';
			if(index==2)
				ret = 'c';
			break;
		case 3:
			if(index==0)
				ret = 'd';
			if(index==1)
				ret = 'e';
			if(index==2)
				ret = 'f';
			break;
		case 4:
			if(index==0)
				ret = 'g';
			if(index==1)
				ret = 'h';
			if(index==2)
				ret = 'i';
			break;
		case 5:
			if(index==0)
				ret = 'j';
			if(index==1)
				ret = 'k';
			if(index==2)
				ret = 'l';
			break;
		case 6:
			if(index==0)
				ret = 'm';
			if(index==1)
				ret = 'n';
			if(index==2)
				ret = 'o';
			break;
		case 7:
			if(index==0)
				ret = 'p';
			if(index==1)
				ret = 'q';
			if(index==2)
				ret = 'r';
			break;
		case 8:
			if(index==0)
				ret = 't';
			if(index==1)
				ret = 'u';
			if(index==2)
				ret = 'v';
			break;
		case 9:
			if(index==0)
				ret = 'w';
			if(index==1)
				ret = 'x';
			if(index==2)
				ret = 'y';
			break;
	}
	return ret;
}