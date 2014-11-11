//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
   public ListNode mergeKLists(List<ListNode> lists) {
        if(lists==null || lists.size()==0)
            return null;
        return mergeKListsHelper(lists, 0, lists.size()-1);
    }
    
    ListNode mergeKListsHelper(List<ListNode> lists, int l, int h){
        if(l<h){
            int m = (l+h)/2;
            return merge2Lists( mergeKListsHelper(lists, l, m), mergeKListsHelper(lists, m+1, h) );
        }
        return lists.get(l);
    }
    
    private ListNode merge2Lists(ListNode la, ListNode lb){
        if(la==null)
            return lb;
        if(lb==null)
            return la;
        ListNode head=null, p=null;
        while(la!=null && lb!=null){
            int val = 0;
            if(la.val<=lb.val){
                val = la.val;
                la = la.next;
            }else{
                val = lb.val;
                lb = lb.next;
            }
            if(head==null){
                head = new ListNode(val);
                p = head;
            }else{
                p.next = new ListNode(val);
                p = p.next;
            }
        }
        p.next = ( (la==null) ? lb : la );
        return head;
    }
}