/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) 
    {
        if(head == null || head.next == null) 
			return head;
        
        ListNode pre = head;
        ListNode pt = head.next;
        pre.next = null;
        ListNode next;
        while(pt != null) 
        {
            next = pt.next;
            pt.next = pre;
            pre = pt;
            pt = next;
        }
        return pre;
    }
}