//number is 32,000  memory is 4kb. Print all duplicate elements in the array?

//Can use Bitset 4kb = 4096 byte = 4096 * 8 > 32,000

void findDuplicate(int[] array){
	if(array==null || array.length==0)
		return;
	Bitset bs = new Bitset(array.length);
	for(int i=0; i<array.length; i++){
		if(bs.get(array[i])==true)
			print(array[i]);
		else
			bs.set(array[i]);
	}
}