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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null || inorder.length==0 || postorder.length==0)
            return null;
        return createTree(inorder, postorder, postorder.length-1, 0, postorder.length);
    }
    private TreeNode createTree(int[] inorder, int[] postorder, int i, int j, int len){
        if(len<=0)
            return null;
        int m = postPosInorder(postorder[i], inorder);
        TreeNode root = new TreeNode(postorder[i]);
        root.right = createTree(inorder, postorder, i-1, m+1, len-(m-j)-1);
        root.left = createTree(inorder, postorder, i-(len-(m-j)-1)-1, j, m-j);
        return root;
    }
    private int postPosInorder(int num, int[] inorder){
        for(int k=0; k<inorder.length; k++){
            if(num==inorder[k])
                return k;
        }
        return -1;
    }
}