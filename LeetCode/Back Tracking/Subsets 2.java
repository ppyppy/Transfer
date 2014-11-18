//Given a collection of integers that might contain duplicates, S, return all possible subsets.
//
//Note:
//Elements in a subset must be in non-descending order.
//The solution set must not contain duplicate subsets.
//For example,
//If S = [1,2,2], a solution is:
//
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        lists.add(list);
        if(num==null || num.length==0)
            return lists;
        Arrays.sort(num);
        helper(num, 0, list, lists);
        return lists;
    }
    
    void helper(int[] num, int start, List<Integer> list, List<List<Integer>> lists){
        for(int i=start; i<num.length; i++){
            list.add(num[i]);
            lists.add(new ArrayList<Integer>(list));
            helper(num, i+1, list, lists);
            list.remove(list.size()-1);
            while(i<num.length-1 && num[i]==num[i+1])
                i++;
        }
    }
}

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for(int i=0; i<(1<<num.length); i++){
            List<Integer> l = new ArrayList<Integer>();
            for(int j=0; j<num.length; j++){
                if( ( i&(1<<j) ) > 0 ){
                    l.add(num[j]);
                } 
            }
            set.add(l);
        }
        for(List<Integer> list : set){
        	ll.add(list);
        }
        return ll;
    }
}