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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        int lenA = getLength(headA), lenB = getLength(headB);
        if(lenA > lenB)
        {
            int dist = lenA - lenB;
            for(int i = dist; i > 0; i--)
                headA = headA.next;
        }
        else if(lenA < lenB)
        {
            int dist = lenB - lenA;
            for(int i = dist; i > 0; i--)
                headB = headB.next;
        }
        
        while(headA != null && headA != headB)
        {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
    
    private int getLength(ListNode node)
    {
        int length = 0;
        while(node != null)
        {
            node = node.next;
            length++;
        }
        return length;
    }
}