
void QuickSort(int[] n, int low, int high){
	if(n==null || n.length<=1)
		return;
	if(low<high){
		int m = partition(n, low, high);
		QuickSort(n, low, m-1);
		QuickSort(n, m+1, high);
	}
}

int partition(int[] n, int low, int high){
	int key = n[low];
	while(low<high){
		while(low<high && n[high]>=key){
			high--;
		}
		n[low] = n[high];
		while(low<high && n[low]<=key){
			low++;
		}
		n[high] = n[low];
	}
	n[low] = key;
	return low;
}