import java.util.Arrays;
import java.util.Collections;

//给一堆[start, end]的区间，求总覆盖长度 

//[3,5] [4,7] [3,8] [4,9] [6,8] [9,13] [10,11]

class Range{
	int s;
	int e;
	public Range(int sv, int ev){
		s = sv;
		e = ev;
	}
}

class RangeComparator implements Comparator<Range>{
	@Override
	public int compare(Range r1, Range r2) {
		// TODO Auto-generated method stub
		if(r1.s<r2.s)
			return -1;
		else if(r1.s==r2.s)
			return 0;
		else
			return 1;
	}
}

int getRange(Range[] ranges){
	if(ranges==null || ranges.length==0)
		return 0;
	int start = 0, ret = 0;
	Arrays.sort(ranges, new RangeComparator());
	for(Range range : ranges){
		if(range.e<=start)
			continue;
		else if(range.s<start)
			range.s = start;
		ret += range.e-range.s;
		start = range.e;
	}
	return ret;
}


