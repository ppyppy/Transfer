//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
//For example, this binary tree is symmetric:
//
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//But the following is not:
//    1
//   / \
//  2   2
//   \   \
//   3    3

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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode ln, TreeNode rn){
        if(ln==null && rn==null)
            return true;
        else if(ln==null || rn==null)
            return false;
        else if(ln.val==rn.val)
            return ( isSymmetric(ln.left, rn.right) && isSymmetric(ln.right, rn.left) );
        else
            return false;
    }
}


public class Solution {
    public boolean isSymmetric(TreeNode root) {
		if(root==null)
			return true;
		TreeNode rn = root, ln = root;
		LinkedList<TreeNode> lq = new LinkedList<TreeNode>();
		LinkedList<TreeNode> rq = new LinkedList<TreeNode>();
		lq.addFirst(ln);
		rq.addFirst(rn);
		while(!lq.isEmpty() && !rq.isEmpty()){
			ln = lq.removeLast();
			rn = rq.removeLast();
			if(ln.left!=null && rn.right!=null && ln.left.val==rn.right.val){
				lq.addFirst(ln.left);
				rq.addFirst(rn.right);
			} 
			if(ln.right!=null && rn.left!=null && ln.right.val==rn.left.val){
				lq.addFirst(ln.right);
				rq.addFirst(rn.left);
			}
			
			if( (ln.left==null && rn.right!=null) || (ln.left!=null && rn.right==null)  )
				return false;
			else if ( (ln.right==null && rn.left!=null) || (ln.right!=null && rn.left==null)  )
				return false;
			else if(ln.left!=null && rn.right!=null && ln.left.val!=rn.right.val )
				return false;
			else if(ln.right!=null && rn.left!=null && ln.right.val!=rn.left.val )
				return false;
		}
		return true;
    }
}