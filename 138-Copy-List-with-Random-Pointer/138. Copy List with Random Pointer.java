/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) 
	{
        if(head == null) 
        	return null;
        RandomListNode n1 = head;
        RandomListNode n2;
        // 生成新节点并接在旧节点后面，注意末尾节点没有接上新节点，仍然指向空
        while(n1 != null)
        {
            n2 = new RandomListNode(n1.label);
            n2.next = n1.next;
            n1.next = n2;
            n1 = n1.next.next;
        }
        // 给新节点的random字段赋值
        n1 = head;
        n2 = n1.next;
        while(n1 != null)
        {
            n2.random = n1.random != null ? n1.random.next : null;
            n1 = n1.next.next;
            n2 = n1 != null ? n2.next.next : null;
        }
        n1 = head;
        n2 = n1.next;
        RandomListNode res = n2;
        // 将新旧节点分开
        while(n1 != null)
        {
            n1.next = n1.next.next;
            n2.next = n2.next != null ? n2.next.next : null;
            n1 = n1.next;
            n2 = n2.next;
        }
        return res;
    }
}