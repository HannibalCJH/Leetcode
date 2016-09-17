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
    int max = 0;
	
	public List<Integer> rightSideView(TreeNode root) 
	{
        if(root == null)
        	return new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        dfs(result, root, 1);
        return result;
    }
	
	private void dfs(List<Integer> res, TreeNode node, int level)
	{
		if(node == null)
			return;
		
		if(level > max)
		{
			res.add(node.val);
			max = level;
		}
		dfs(res, node.right, level + 1);
		dfs(res, node.left, level + 1);
	}
}