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
        
        for(int i = 0; i < lists.length; i++)
        {  
            if(lists[i] != null)  
            	queue.add(lists[i]);  
        }
        
        ListNode head = null, current = null;
        
        while(!queue.isEmpty())
        {  
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
            if(current.next != null)  
            	queue.add(current.next);  
        }  
        return head;  
    }
}