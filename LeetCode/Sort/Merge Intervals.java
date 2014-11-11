//Given a collection of intervals, merge all overlapping intervals.
//
//For example,
//Given [1,3],[2,6],[8,10],[15,18],
//return [1,6],[8,10],[15,18].

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<Interval>();
        if(intervals==null || intervals.size()==0)
            return list;
        Collections.sort(intervals, new myComparator());
        Interval cur = null;
        for(Interval interval : intervals){
            if(cur==null)
                cur = interval;
            else{
                if(cur.end>=interval.start){
                    cur = new Interval(cur.start, Math.max(cur.end, interval.end));
                }else{
                    list.add(cur);
                    cur = interval;
                }
            }
        }
        list.add(new Interval(cur.start, cur.end));
        return list;
    }
}

class myComparator implements Comparator<Interval>{
	@Override
	public int compare(Interval p1, Interval p2) {
		if(p1.start > p2.start)
			return 1;
		else if(p1.start < p2.start)
			return -1;
		else
			return 0;
	}
}