//(height, weight) (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)

	//First sort with height:
	void sort(Point[] points){
		if(points==null || points.length<2)
			return;
		Arrays.sort(points, new pointComparator());
		GetLongestIncreasingSubSequence(points);
	}
	//Then sort with weight
	/* 7 8 11 9 6 12 15 14 13 3
	   1 2 3  4 1 4  5  5  5  1
	   0 0 1  1 4 2  5  5  5  9
	 */
	void GetLongestIncreasingSubSequence(Point[] ps){
		int length = ps.length;
		int[] nl = new int[length];
		int[] pre = new int[length];
		for(int i=0; i<length; i++){
			nl[i] = 1;
			pre[i] = i;
		}
		int index = -1, max = 0;
		for(int i=1; i<length; i++)
			for(int j=0; j<i; j++){
				if(ps[j].y<ps[i].y && (nl[j]+1)>nl[i]){
					nl[i] = nl[j]+1;
					pre[i] = j;
					if(nl[i]>max){
						max = nl[i];
						index = i;
					}
				}
			}
		while(pre[index]!=index){
			System.out.println(ps[index].x + ", " + ps[index].y);
			index = pre[index];
		}
		System.out.println(ps[index].x + ", " + ps[index].y);
	}

class pointComparator implements Comparator<Point> {
	@Override
	public int compare(Point p1, Point p2) {
		if (p1.x > p2.x)
			return 1;
		else if (p1.x < p2.x)
			return -1;
		else
			return 0;
	}
}