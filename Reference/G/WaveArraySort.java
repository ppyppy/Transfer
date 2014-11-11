//sort array to a1<=a2>=a3<=a4>=...

void waveSort(int[] array){
	if(array==null || array.length<2)
		return;
	boolean isSmall = true;
	for(int i=0; i<array.length-1; i++){
		if( (isSmall&&array[i]>array[i+1]) || (!isSmall&&array[i]<array[i+1]) ){
			int temp = array[i];
			array[i] = array[i+1];
			array[i+1] = temp;
		}
		isSmall = !isSmall;
	}
}