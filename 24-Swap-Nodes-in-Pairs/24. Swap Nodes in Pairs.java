/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) 
    {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        ListNode preNode = dummy;
        // 头节点将是第二个节点
        dummy.next = head.next;
        // 交换
        while(head != null && head.next != null)
        {
            // 存第二个节点
            ListNode temp = head.next;
            // 第一个节点指向第三个节点
            head.next = temp.next;
            // 前驱节点指向第二个节点
            preNode.next = temp;
            // 第二个节点指向第一个节点
            temp.next = head;
            // 移到第三个节点进行下一步
            preNode = head;
            head = head.next;
        }
        return dummy.next;
    }
}