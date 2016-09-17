/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 我的算法
	TreeNode pre;
	
	public boolean isValidBST(TreeNode root) 
	{
        if(root == null)
        	return true;
        
        return dfs(root);
    }
	
	// 从最底层开始比较
	private boolean dfs(TreeNode node)
	{
		if(node == null)
			return true;
		
		boolean left, right;
		
		left = dfs(node.left);
		if(pre != null && pre.val >= node.val)
			return false;
		pre = node;
		right = dfs(node.right);
		
		return left && right;
	}
}