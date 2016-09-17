public class MinStack {
    
    // stack: store the stack numbers
    private Stack<Integer> stack;
    // minStack: store the current min values
    private Stack<Integer> minStack;
	
	/** initialize your data structure here. */
	// 构造函数
    public MinStack() 
    {
    	stack = new Stack<Integer>();
    	minStack = new Stack<Integer>();
    }
    
    public void push(int x) 
    {
        // minStack栈顶为最小元素
    	// 这里的思路是你后面可能压入比较大的元素，但是pop时肯定是比较大的元素先被pop
    	// 所以不用关心是否把那些大的元素压入minStack
        if(minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
        stack.push(x);
    }

    public void pop() 
    {
        // 如果两个栈顶元素相同则都pop
        if(stack.peek().equals(minStack.peek()))
            minStack.pop();
        stack.pop();
    }

    public int top() 
    {
        return stack.peek();
    }

    public int getMin() 
    {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */