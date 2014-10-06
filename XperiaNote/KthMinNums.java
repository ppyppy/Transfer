// Find kth minimum number from a large amont data
//use random select O(n), T(n) <= T(Pn) + O(n) where P<1 usually, T(n) <= T((9/10)*n) + O(n)
//if use heapsort, it will be nLog(k), heap size is k
int RandomizedSelect(int[] num, int l, int h, int k){
	if(l==h)
		return num[l];
	int mid = RandomPartitionSort(num, l, h);
	int rank = mid-l+1;
	if(rank==k)
		return num[mid];
	else if(rank>k)
		return RandomizedSelect(num, l, mid-1, k);
	else
		return RandomizedSelect(num, mid+1, h, k-rank);
}

int RandomPartitionSort(int[] num, int l, int  h){
	int index = Math.random()*(h-l) + l;
	num[index] <---> num[l];
	return partition(array, l, h);
	//use one step like quick sort, use first value as pivot, then after a round get the pivot index
}