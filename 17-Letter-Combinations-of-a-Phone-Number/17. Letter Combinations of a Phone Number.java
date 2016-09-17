public class Solution {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
	public List<String> letterCombinations(String digits) 
	{
		List<String> result = new ArrayList<String>();
		if(digits == null || digits.length() == 0)
		    return result;
		combination("", digits, 0, result);
		return result;
	}

	private void combination(String prefix, String digits, int offset, List<String> result) 
	{
		// 得到一个规定长度的组合
		if(offset >= digits.length()) 
		{
			result.add(prefix);
			return;
		}
		// 获取这个数字可以表示的所有字母
		String letters = KEYS[(digits.charAt(offset) - '0')];
		// 对每一个可能的字母递归并回溯
		for(int i = 0; i < letters.length(); i++)
			combination(prefix + letters.charAt(i), digits, offset + 1, result);
	}
}