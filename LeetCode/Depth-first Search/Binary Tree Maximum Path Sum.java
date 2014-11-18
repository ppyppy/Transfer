//Given a binary tree, find the maximum path sum.
//
//The path may start and end at any node in the tree.
//
//For example:
//Given the below binary tree,
//
//       1
//      / \
//     2   3
//Return 6.

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
    int maxVal;
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        maxVal = Integer.MIN_VALUE;
        helper(root);
        return maxVal;
    }

    private int helper(TreeNode root){
        if(root==null)
            return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        int val = root.val;
        if(l>0)
            val += l;
        if(r>0)
            val += r;
        maxVal = Math.max(maxVal, val);
        return Math.max(root.val, Math.max(root.val+l, root.val+r));
    }
   
}