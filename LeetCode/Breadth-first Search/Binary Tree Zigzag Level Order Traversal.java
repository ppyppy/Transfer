//Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
//
//For example:
//Given binary tree {3,9,20,#,#,15,7},
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its zigzag level order traversal as:
//[
//  [3],
//  [20,9],
//  [15,7]
//]

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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return lists;
        LinkedList<LevelNode> queue = new LinkedList<LevelNode>();
        queue.addFirst(new LevelNode(root, 1));
        ArrayList list = new ArrayList<Integer>();
        int preLevel = 1;
        while(!queue.isEmpty()){
            LevelNode lnode = queue.removeLast();
            TreeNode tnode = lnode.node;
            if(lnode.level==preLevel)
                list.add(tnode.val);
            else{
                if(preLevel%2==0)
                    Collections.reverse(list);
                lists.add(list);
                list = new ArrayList<Integer>();
                list.add(tnode.val);
                preLevel = lnode.level;
            }
            if(tnode.left!=null)
                queue.addFirst(new LevelNode(tnode.left, lnode.level+1));
            if(tnode.right!=null)
                queue.addFirst(new LevelNode(tnode.right, lnode.level+1));
        }
        if(preLevel%2==0)
            Collections.reverse(list);
        lists.add(list);
        return lists;
    }
}

class LevelNode{
    public TreeNode node;
    public int level;
    public LevelNode(TreeNode nd, int num){
        node = nd;
        level = num;
    }
}