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
    // 我的算法
	public boolean hasCycle(ListNode head) 
	{
        if(head == null || head.next == null)
        	return false;
        
        // 双指针，快指针比慢指针快一步，如果最后快指针追上了慢指针说明有环
        ListNode slow = head, fast = head;
        while(fast.next != null)
        {
        	fast = fast.next;
        	if(fast.next != null)
        		fast = fast.next;
        	else
        		break;
        	slow = slow.next;
        	// 快指针追上慢指针，有环
        	if(fast == slow)
        		return true;
        }
        
        return false;
    }
}