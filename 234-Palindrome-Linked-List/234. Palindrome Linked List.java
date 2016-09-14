/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 我的算法
	public boolean isPalindrome(ListNode head) 
	{
        int count = 0;
        
        ListNode temp = head;
        // 遍历一遍得到节点总数
        while(temp != null)
        {
        	temp = temp.next;
        	count++;
        }
        temp = head;
        int[] half = new int[count / 2];  // 存储前一半节点值，奇数个情况下不包括中间点
        // 以下两个for循环都为遍历第二遍，分别是前半部分和后半部分
        // 第二遍遍历前半部分，存储前一半的值
        for(int i = 0; i < count / 2;i++)
        {
        	half[i] = temp.val;
        	temp = temp.next;
        }
        // 奇数个情况下跳过中间节点
        if(count % 2 > 0)
        	temp = temp.next;
        // 第二遍遍历后半部分，逐一比较
        for(int i = count / 2 - 1; i >= 0; i--)
        {
        	if(temp.val != half[i])
        		return false;
        	temp = temp.next;
        }
        return true;
    }
}