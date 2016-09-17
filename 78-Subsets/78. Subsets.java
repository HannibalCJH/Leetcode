public class Solution {
    public List<List<Integer>> subsets(int[] nums) 
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(nums == null || nums.length == 0)
            return result;
        
        dfs(result, list, nums, 0);

        return result;
    }
	
	private void dfs(List<List<Integer>> result, List<Integer> list, int[] num, int pos) 
	{
        result.add(new ArrayList<Integer>(list));
        
        for(int i = pos; i < num.length; i++) 
        {
            list.add(num[i]);
            dfs(result, list, num, i + 1);
            list.remove(list.size() - 1);  // 回溯
        }
    }
}