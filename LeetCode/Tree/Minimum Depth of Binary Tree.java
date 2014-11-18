//Given a binary tree, find its minimum depth.
//
//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

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
    int min;
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        min = Integer.MAX_VALUE;
        helper(root, 0);
        return min;
    }
    
    void helper(TreeNode root, int n){
        n++;
        if(root.left==null && root.right==null){
            if(n<min)
                min = n;
            return;
        }
        if(root.left!=null)
            helper(root.left, n);
        if(root.right!=null)
            helper(root.right, n);
    }
}