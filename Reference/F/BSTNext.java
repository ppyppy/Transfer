//Iterator for in-order traversal of binary tree.  开始以为是iterative traverse in-order binary tree
//
//
//class Iterator
//{
//    Iterator(Node *root){ }
//    int value(){ }. Waral 鍗氬鏈夋洿澶氭枃绔�,
//    void next(){ }. 涓€浜�-涓夊垎-鍦帮紝鐙鍙戝竷
//
//}

import java.util.Stack;
public class IteratorOfInOrder {        
        private TreeNode curr;
        private Stack<TreeNode> nodes = new Stack<TreeNode>();
        public IteratorOfInOrder(TreeNode root){
                TreeNode nd = root;
                while(nd != null){-google 1point3acres
                        nodes.add(nd);
                        nd = nd.left;
                }                
        }
        
        public int value(){                        
                return curr.val;                
        }

        public void next(){
                if(!nodes.isEmpty()){
                        curr = nodes.pop();                        
                }
                
                if(curr != null) {
                        TreeNode nd = curr;
                        if(nd.right != null) {
                                nd = nd.right;
                                while(nd != null) {
                                        nodes.push(nd);
                                        nd = nd.left;
                                }
                        }                        
                }else{
                        System.out.println("reach the last node in the tree");
                }
        }
}