//给一个string， 返回所有出现次数为奇数的char.
//string="ababcdgeef"
//那么当扫到a的时候，array[0]=array[0]^1 = 1;
//当扫到b的时候，array[1]=array[1]^1 = 1;
//第三个a的时候，array[0]=array[0]^1 = 0;
//扫完后，遍历数组，print if array[k] = 1;

int[] getOddChars(String str){
	if(str==null || str.length()==0){
		return null;
	}
	int[] val = new int[26];
	char[] chs = str.toCharArray();
	for(int i=0; i<chs.length; i++){
		val[chs[i]-'a'] = val[chs[i]-'a']^1;
	}
	return val;
}