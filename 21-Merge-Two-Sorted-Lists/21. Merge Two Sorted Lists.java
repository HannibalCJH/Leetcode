/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
        ListNode dummy = new ListNode(-1);
        ListNode preNode = dummy;
        while(l1 != null && l2 != null)
        {
            if(l1.val <= l2.val)
            {
                preNode.next = l1;
                l1 = l1.next;
            }
            else
            {
                preNode.next = l2;
                l2 = l2.next;
            }
            preNode = preNode.next;
        }
        if(l1 != null)
        {
            preNode.next = l1;
            l1 = l1.next;
            preNode = preNode.next;
        }
        if(l2 != null)
        {
            preNode.next = l2;
            l2 = l2.next;
            preNode = preNode.next;
        }
        return dummy.next;
    }
}