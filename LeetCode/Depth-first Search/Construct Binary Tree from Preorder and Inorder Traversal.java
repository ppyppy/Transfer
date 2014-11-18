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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null || preorder.length==0 || inorder.length==0)
            return null;
        return createTree(preorder, inorder, 0, 0, preorder.length);
    }
    private TreeNode createTree(int[] preorder, int[] inorder, int i, int j, int len){
        if(len<=0)
            return null;
        int m = prePosInorder(preorder[i], inorder);
        TreeNode root = new TreeNode(preorder[i]);
        root.left = createTree(preorder, inorder, i+1, j, m-j);
        root.right = createTree(preorder, inorder, i+(m-j)+1, m+1, len-(m-j)-1);
        return root;
    }
    private int prePosInorder(int num, int[] inorder){
        for(int k=0; k<inorder.length; k++){
            if(num==inorder[k])
                return k;
        }
        return -1;
    }
}