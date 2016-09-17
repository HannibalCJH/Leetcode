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
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        if(root == null)
            return result;
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> curLevel = new ArrayList<Integer>();
            for(int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                curLevel.add(node.val);
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            result.add(curLevel);
        }
        return result;
    }
}