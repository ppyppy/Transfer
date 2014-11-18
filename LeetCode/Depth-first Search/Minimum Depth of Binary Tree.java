//Minimum Depth of Binary Tree
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
    private int min;
    public int minDepth(TreeNode root) {
        min = Integer.MAX_VALUE;
        if(root==null)
            return 0;
        traverTree(root, 1);
        return min;
    }
    private void traverTree(TreeNode t, int height){
        if(t.left==null && t.right==null){
            if(min>height)
                min = height;
                return;
        }
        if(t.left!=null)
            traverTree(t.left, height+1);
        if(t.right!=null)
            traverTree(t.right, height+1);
    }
}
