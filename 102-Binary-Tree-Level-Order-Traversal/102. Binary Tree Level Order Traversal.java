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
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        if(root == null)
            return result;
        queue.offer(root);
        while(!queue.isEmpty())
        {
            // 这一层的节点数
            int size = queue.size();
            // 记录这一层的节点值
            List<Integer> curLevel = new ArrayList<Integer>();
            for(int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                // 加入节点值
                curLevel.add(node.val);
                // 左右子树不会空则加入队列
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            // 把这层的节点值加入到结果集中
            result.add(curLevel);
        }
        return result;
    }
}