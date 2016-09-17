public class LRUCache {
    
    // 双向链表节点定义
	public class ListNode 
	{
        ListNode prev;
        ListNode next;
        int val;
        int key;
        public ListNode(int v, int k)
        {
            this.val = v;
            this.prev = null;
            this.next = null;
            this.key = k;
        }
    }
	
	int size;
    int capacity;
    ListNode tail;
    ListNode head;
    Map<Integer, ListNode> map;
    
    // 参考博文: https://segmentfault.com/a/1190000003743083
	// 构造函数
	public LRUCache(int capacity) 
	{
		this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        // 初始化头尾节点，这两个节点不存值，仅作为头尾指针
        head.next = tail;
        tail.prev = head;
        // 链表现有节点数
        this.size = 0;
        // 链表容量
        this.capacity = capacity;
        this.map = new HashMap<Integer, ListNode>();
    }
    
	public int get(int key) 
	{
		// 获取键值对应的节点
        ListNode n = map.get(key);
        // 键值存在
        if(n != null)
        {
            moveToHead(n); // 把节点移到头，表示最近有访问过
            return n.val;  // 返回键值对应的值
        } 
        else
        	// 键值不存在则返回-1
            return -1;
    }
    
    public void set(int key, int value) 
    {
    	// 获取键值对应的节点
        ListNode n = map.get(key);
        // 键值不存在
        if(n == null)
        {
            n = new ListNode(value, key);  // 新建节点并赋值
            attachToHead(n);               // 把节点加到表头，表示最近访问过
            size++;
        } 
        // 键值存在
        else 
        {
            n.val = value;  // 替换键值对应的值
            moveToHead(n);  // 把节点移到头，表示最近有访问过
        }
        // 如果更新节点后超出容量，删除最后一个
        if(size > capacity)
        {
            removeLast();
            size--;
        }
        map.put(key, n);
    }
    
    // 将一个孤立节点放到头部
    private void attachToHead(ListNode n)
    {
        n.next = head.next;
        n.next.prev = n;
        head.next = n;
        n.prev = head;
    }
    
    // 将一个链表中的节点放到头部
    private void moveToHead(ListNode n)
    {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        attachToHead(n);
    }
    
    // 移出链表最后一个节点
    private void removeLast()
    {
        ListNode last = tail.prev;
        last.prev.next = tail;
        tail.prev = last.prev;
        map.remove(last.key);
    }
}