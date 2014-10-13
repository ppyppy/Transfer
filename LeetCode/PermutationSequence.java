//For n=4, k=20,  
// 1*** 3!
// 2*** 3!
// 3*** 3!
// 4321 19(3*3!+1) 
// so 20 = 3*3! + 1*1! + 1  //start from 1
// index sequence 3010, from 1234 => 4132
public String getPermutation(int n, int k) {
	if(k<0 || k>factorial(n))
		return "";
	int[] index = new int[n];
	for(int i=n-1; i>=0; i--){
		int value = factorial(i);
		while(k-1 >= value){
			index[n-1-i]++;
			k -= value;
		}
	}
	ArrayList<Integer> list = new ArrayList<Integer>();
	for(int i=1; i<=n; i++)
		list.add(i);
	StringBuilder sb = new StringBuilder();
	for(int i=0; i<index.length; i++){
		sb.append(list.get(index[i]));
		list.remove(index[i]);
	}
	return sb.toString();
}

int factorial(int n){
	int sum=1;
	while(n>0){
		sum *= n;
		n--;
	}
	return sum;
}