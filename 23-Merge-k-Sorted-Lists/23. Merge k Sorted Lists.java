/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) 
    {
        if(lists == null || lists.length == 0)  
            return null;
        // 比较器
        Comparator<ListNode> comparator = new Comparator<ListNode>()
        {  
            public int compare(ListNode m, ListNode n)
            {  
                if(m.val == n.val)  
                    return 0;  
                else if(m.val > n.val)  
                    return 1;  
                else  
                    return -1;  
            }  
        };
        
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, comparator);
        
        // 把所有链表加入优先队列，并按照链表头节点的大小排序
        for(int i = 0; i < lists.length; i++)
            if(lists[i] != null)  
            	queue.add(lists[i]);  
        
        ListNode head = null, current = null;
        
        while(!queue.isEmpty())
        { 
        	// 每次从优先队列中得到值最小的节点
            if(head == null)
            {  
                head = queue.poll();  
                current = head;  
            }  
            else
            {  
            	current.next = queue.poll();  
            	current = current.next;  
            }
            // 这个被选取的链表还有剩余的节点则把下一个节点加入优先队列并排序
            if(current.next != null)  
            	queue.add(current.next);  
        }  
        return head;  
    }
}