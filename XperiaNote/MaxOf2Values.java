int max(int a, int b){
	boolean ret = (((a-b)>>>31)&0x1) > 0;
	return ret ? b : a;
}
