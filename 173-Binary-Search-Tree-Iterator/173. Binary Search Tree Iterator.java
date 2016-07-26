/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    Stack<TreeNode> stack;
	
	// 构造函数
    public BSTIterator(TreeNode root) 
    {
        stack = new Stack<TreeNode>();
        // 先找到第一个节点，并把路径入栈
        while(root != null)
        {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() 
    {        
        // 栈为空时不再有下一个
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() 
    {
        // 栈顶是待返回元素
        TreeNode curr = stack.pop();
        int res = curr.val;
        // 如果该元素有右节点，把它的右节点及右节点的所有左边节点都压入栈中
        if(curr.right != null)
        {
            curr = curr.right;
            while(curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
        }
        return res;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */