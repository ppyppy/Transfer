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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return lists;
        LinkedList<LevelNode> queue = new LinkedList<LevelNode>();
        queue.addFirst(new LevelNode(root, 0));
        int preLevel = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            LevelNode lnode = queue.removeLast();
            TreeNode tnode = lnode.node;
            if(lnode.level==preLevel){
                list.add(tnode.val);
            } else{
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