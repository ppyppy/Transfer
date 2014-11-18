//Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//Each number in C may only be used once in the combination.
//
//Note:
//All numbers (including target) will be positive integers.
//Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//The solution set must not contain duplicate combinations.
//For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
//A solution set is: 
//[1, 7] 
//[1, 2, 5] 
//[2, 6] 
//[1, 1, 6] 

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists  = new ArrayList<List<Integer>>();
        if(candidates==null || candidates.length==0)
            return lists;
        Arrays.sort(candidates);
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(candidates, 0, target, list, lists);
        return lists;
    }
    
    private void helper(int[] nums, int index, int target, List<Integer> list, List<List<Integer>> lists){
        if(target<0)
            return;
        if(target==0){
            //Collections.sort(list);
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=index; i<nums.length; i++){
            list.add(nums[i]);
            combinationSum(nums, i+1, target-nums[i], list, lists);
            list.remove(list.size()-1);
            while(i<nums.length-1 && nums[i]==nums[i+1]) //already tried by one num[i], don't need to try one num[i+1] if they are same
                i++;
        }
    }
}