//Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
//
//For example,
//Given n = 3, your program should return all 5 unique BST's shown below.
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }
    
    public List<TreeNode> generateTrees(int low, int high){
    	List<TreeNode> list = new ArrayList<TreeNode>();
    	if(low>high){
    		list.add(null);
    		return list;
    	}
        for(int i=low; i<=high; i++){
            List<TreeNode> leftSet = generateTrees(low, i-1);
            List<TreeNode> rightSet = generateTrees(i+1, high);
            for(TreeNode left : leftSet){
                for(TreeNode right : rightSet){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
    	return list;
    }
}