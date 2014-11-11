//Sort a linked list in O(n log n) time using constant space complexity.
//

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null)
            return head;
        int count = 0;
        ListNode p = head;
        while(p!=null){
            p = p.next;
            count++;
        }
        if(count<2)
            return head;
        int mid = (count+1)/2;
        ListNode midNode = head;
        while(mid-1>0){
            midNode = midNode.next;
            mid--;
        }
        ListNode lh = midNode.next;
        midNode.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(lh);
        return mergeList(l1, l2);
    }
    
    public ListNode mergeList(ListNode l1, ListNode l2){
        ListNode h = null, p = null;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                if(h==null){
                    h = l1;
                    p = h;
                }else{
                    p.next = l1;
                    p = p.next;
                }
                l1 = l1.next;
            }else{
                if(h==null){
                    h = l2;
                    p = h;
                }else{
                    p.next = l2;
                    p = p.next;
                }
                l2 = l2.next;
            }
        }
        if(l1==null){
            p.next = l2;
        }else if(l2 == null){
            p.next = l1;
        }
        return h;
    }
}