//Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//The same repeated number may be chosen from C unlimited number of times.
//
//Note:
//All numbers (including target) will be positive integers.
//Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//The solution set must not contain duplicate combinations.
//For example, given candidate set 2,3,6,7 and target 7, 
//A solution set is: 
//[7] 
//[2, 2, 3] 

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(candidates==null || candidates.length==0)
            return lists;
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<Integer>();
        helper(candidates, target, 0, lists, list);
        return lists;
    }
    
    void helper(int[] candidates, int target, int index, List<List<Integer>> lists, List<Integer> list){
        if(target<0){
            return;
        }else if(target==0){
            lists.add(new ArrayList(list));
            return;
        }
        for(int i=index; i<candidates.length; i++){
            list.add(candidates[i]);
            helper(candidates, target-candidates[i], i, lists, list);
            list.remove(list.size()-1);
        }
    }
}