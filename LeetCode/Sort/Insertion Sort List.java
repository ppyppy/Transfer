//Sort a linked list using insertion sort.

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
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode p = head, pre = head, q = head.next;
        while(q!=null){
            p = head;
            if(q.val<pre.val){
                if(q.val<head.val){
                    head = q;
                    pre.next = q.next;
                    q.next = p;
                }else{
                    while(q.val>=p.next.val)
                        p = p.next;
                    pre.next = q.next;
                    q.next = p.next;
                    p.next = q;
                }
            }
            pre = q;
            q = q.next;
        }
        return head;
    }
}
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode p=head, pre=head, q=null;
        while(p!=null){
            if(p.val<pre.val){
                if(p.val<head.val){
                    pre.next = p.next;
                    p.next = head;
                    head = p;
                }else{
                    q=head;
                    while(q.next.val<p.val){
                        q = q.next;
                    }
                    pre.next = p.next;
                    p.next = q.next;
                    q.next = p;
                }
                p = pre.next;
            }else{
                pre = p;
                p = p.next;
            }
        }
        return head;
    }
}



