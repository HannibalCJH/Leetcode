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
    // 我的算法
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        // 计算每个链表长度
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
        // 如果没有重合那跳出循环时两个头指针都指向空
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