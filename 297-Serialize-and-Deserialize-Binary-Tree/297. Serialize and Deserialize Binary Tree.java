/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) 
    {
        StringBuilder sb = new StringBuilder();
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        // BFS逐层搜索
        while(!queue.isEmpty()) 
        {
            TreeNode node = queue.poll();
            // 空节点
            if(node == null)
                sb.append("null,");
            else 
            {
                sb.append(String.valueOf(node.val) + ",");  // 加上该节点
                queue.offer(node.left);                     // 搜索左子树
                queue.offer(node.right);                    // 搜索右子树
            }
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        if(data.isEmpty()) 
        	return null;
        
        String[] vals = data.split(",");
        int[] nums = new int[vals.length]; // 节点i之前空节点的个数
        TreeNode[] nodes = new TreeNode[vals.length];
        
        // 遍历一遍节点，给节点赋值并记录每个节点之前空节点的个数
        for(int i = 0; i < vals.length; i++) 
        {
            if(i > 0)
                nums[i] = nums[i-1];
            
            if(vals[i].equals("null")) 
            {
                nodes[i] = null;
                nums[i]++;
            } 
            else
                nodes[i] = new TreeNode(Integer.parseInt(vals[i]));
        }
        
        // 再次遍历节点，确定每个节点的左右子树
        for(int i = 0; i < vals.length; i++) 
        {
            if(nodes[i] == null)
                continue;
            nodes[i].left = nodes[2 * (i - nums[i]) + 1];
            nodes[i].right = nodes[2 * (i - nums[i]) + 2];
        }
        
        return nodes[0];
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));