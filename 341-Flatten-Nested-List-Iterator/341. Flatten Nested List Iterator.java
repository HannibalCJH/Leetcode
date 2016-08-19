/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack = new Stack<NestedInteger>();
    
    public NestedIterator(List<NestedInteger> nestedList) 
	{
		// 对于集合里的元素从后往前压人栈，这样弹出时就是集合最前面的元素
		for(int i = nestedList.size() - 1; i >= 0; i--)
            stack.push(nestedList.get(i));
    }

    public Integer next() 
    {
    	return stack.pop().getInteger();
    }

    public boolean hasNext() 
    {
    	while(!stack.isEmpty()) 
    	{
            NestedInteger curr = stack.peek();
            if(curr.isInteger())
                return true;
            
            stack.pop();
            for(int i = curr.getList().size() - 1; i >= 0; i--)
                stack.push(curr.getList().get(i));
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */