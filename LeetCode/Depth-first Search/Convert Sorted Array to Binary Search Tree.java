//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

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
    public TreeNode sortedArrayToBST(int[] num) {
        if(num==null)
            return null;
        int low=0, high=num.length-1;
        return getTree(num, low, high);
    }
    private TreeNode getTree(int[] num, int low, int high){
        if(low>high)
            return null;
        int mid = (low+high)/2;
        TreeNode t = new TreeNode(num[mid]);
        t.left = getTree(num, low, mid-1);
        t.right = getTree(num, mid+1, high);
        return t;
    }
}