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

    TreeNode node = null;
    Stack<TreeNode> stack = new Stack<TreeNode>();
	
	// 构造函数
    public BSTIterator(TreeNode root) 
    {
        node = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() 
    {        
        return !((node == null) && stack.empty());
    }

    /** @return the next smallest number */
    public int next() 
    {
        TreeNode res = null;

        if(node == null) 
        {
            res = stack.pop();
            node = res.right;
        } 
        else 
        {
            while(node.left != null) 
            {
                stack.push(node);
                node = node.left;
            }
            res = node;
            node = node.right;
        }
        return res.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */