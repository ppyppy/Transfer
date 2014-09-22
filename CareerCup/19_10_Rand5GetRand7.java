//Observe that doing 5 * rand5() + rand5() gives usexactly one way of getting each number in its range (0 to 24). This ensures 
//that each value is equally probable.

//Could we instead do 2 * rand5() + rand5()? No, because the values wouldn't be equally distributed. 
//For example,there would be two ways of getting a 6 (6=2*1+4 and 6 = 2*2+2)but only one way of getting a 0(0=2*0+0).
//The values in the range are not equally probable.

//rand5() generates 0,1,2,3,4

int rand7(){
	while(true){
		int num = rand5()*5 + rand5();
		if(num<21)
			return num % 7;  //0~6, 7~13, 14~20
	}
}
