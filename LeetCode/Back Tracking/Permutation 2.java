//Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
//For example,
//[1,1,2] have the following unique permutations:
//[1,1,2], [1,2,1], and [2,1,1].

public class Solution {
    List<List<Integer>> lists;
    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        lists = new ArrayList<List<Integer>>();
        if(num==null || num.length==0)
            return lists;
        boolean[] tags = new boolean[num.length];
        permute(num, tags, 0, new ArrayList<Integer>());
        return lists;
    }
    private void permute(int[] num, boolean[] tags, int index, ArrayList<Integer> list){
        if(index==num.length){
            lists.add((List<Integer>)list.clone());
            return;
        }
        for(int i=0; i<num.length; i++){
            if(i>0 && num[i]==num[i-1] && tags[i-1]==false)//same number need visit as sequence
                continue;
            else if(tags[i]==false){
                tags[i] = true;
                list.add(num[i]);
                permute(num, tags, index+1, list);
                tags[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}

public class Solution {
    List<List<Integer>> lists;
    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        lists = new ArrayList<List<Integer>>();
        if(num==null || num.length==0)
            return lists;
        boolean[] tags = new boolean[num.length];
        permute(num, tags, 0, new ArrayList<Integer>());
        return lists;
    }
    private void permute(int[] num, boolean[] tags, int index, ArrayList<Integer> list){
        if(index==num.length){
            lists.add((List<Integer>)list.clone());
            return;
        }
        for(int i=0; i<num.length; i++){
            if(tags[i]==false){
                tags[i] = true;
                list.add(num[i]);
                permute(num, tags, index+1, list);
                tags[i] = false;
                list.remove(list.size()-1);
                while(i<num.length-1 && num[i]==num[i+1])//same number need visit as sequence
                    i++;
            }
        }
    }
}