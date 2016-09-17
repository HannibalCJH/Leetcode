public class Solution {
    // 我的算法
	public List<List<String>> groupAnagrams(String[] strs) 
	{
		List<List<String>> result = new ArrayList<List<String>>();
		if(strs == null || strs.length == 0)
			return result;
		
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for(int i=0;i<strs.length;i++)
		{
			// 每个字符串按字母表顺序排序
			char[] ary = strs[i].toCharArray();
			Arrays.sort(ary);
			String key = Arrays.toString(ary);
			if(map.containsKey(key))
				map.get(key).add(strs[i]);
			else
			{
				List<String> temp = new ArrayList<String>();
				temp.add(strs[i]);
				map.put(key, temp);
			}
		}
		
		for(String key : map.keySet())
			result.add(map.get(key));
		
		return result;
    }
}