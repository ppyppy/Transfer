//Given a binary tree, flatten it to a linked list in-place.
//
//For example,
//Given
//
//         1
//        / \
//       2   5
//      / \   \
//     3   4   6
//The flattened tree should look like:
//   1
//    \
//     2
//      \
//       3
//        \
//         4
//          \
//           5
//            \
//             6

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
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        TreeNode node = root;
        while(node!=null){
            if(node.left!=null){
                TreeNode next = node.right;
                TreeNode right = getRightMost(node.left);
                node.right = node.left;
                node.left = null;
                right.right = next;
            }
            node = node.right;
        }
    }
    
    TreeNode getRightMost(TreeNode node){
        if(node==null)
            return null;
        while(node.right!=null){
            node = node.right;
        }
        return node;
    }
}

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
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        refacTree(root);
        flatten(root.right);        
    }
    private void refacTree(TreeNode root){
        if(root==null || root.left==null)
            return;
        TreeNode rNode = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right!=null)
            root = root.right;
        root.right = rNode;
    }
}