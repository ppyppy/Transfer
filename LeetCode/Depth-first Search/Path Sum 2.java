//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
//For example:
//Given the below binary tree and sum = 22,
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//return
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(root==null)
            return lists;
        helper(root, sum, lists, new ArrayList<Integer>());
        return lists;
    }
    
    void helper(TreeNode node, int sum, List<List<Integer>> lists, ArrayList<Integer> list){
        if(node==null)
            return;
        sum -= node.val;
        list.add(node.val);
        if(sum==0 && node.left==null && node.right==null){
            lists.add( (ArrayList<Integer>)(list.clone()));
        }
        helper(node.left, sum, lists, list);
        helper(node.right, sum, lists, list);
        list.remove(list.size() - 1);
    }
}