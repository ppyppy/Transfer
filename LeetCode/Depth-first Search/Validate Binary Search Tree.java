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
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, int lv, int rv){
        if(root==null)
            return true;
        if(root.val>lv && root.val<rv){
            return isValidBST(root.left, lv, root.val) && isValidBST(root.right, root.val, rv);
        }else{
            return false;
        }
    }
}