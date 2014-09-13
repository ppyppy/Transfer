
void bubble_sort(int[] num){
	int length = num.length;
	boolean change = true;
	for(int i=length-1; i>=1&&change==true; i--){
		change = false;
		for(int j=0; j<i; j++){
			if(num[j]>num[j+1]){
				int temp = num[j];
				num[j] = num[j+1];
				num[j+1] = temp;
				change = true;
			}
		}
	}
}