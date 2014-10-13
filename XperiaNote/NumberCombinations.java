//combinations of number like n=4, k=2: [1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]

ArrayList<ArrayList<Integer>> combine(int n, int k){
	ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
	if(n<k)
		return lists;
	if(k==1){
		for(int i=1; i<=n; i++){
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(i);
			lists.add(list);
		}
		return lists;
	}
	for(int i=n; i>=k; i--){
		for(ArrayList<Integer> list : combine(i-1, k-1)){
			list.add(n);
			lists.add(list);
		}
	}
	return lists;
}