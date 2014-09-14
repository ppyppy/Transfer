
void InsertionSort(int[] n){
	if(n==null || n.length<=1)
		return;
	for(int i=1; i<n.length; i++){
		int j=i-1;
		int pivot = n[i];
		while(j>=0 && n[j]>pivot){
			n[j+1] = n[j];
			j--;
		}
		n[j+1] = pivot;
	}
}