public class Solution {
    public int myAtoi(String str) 
	{
		if (str == null || str.length() < 1)
			return 0;
	 
		// 剪除字符串两边的空格
		str = str.trim();
	 
		boolean minus = false;
	 
		// 检查正负
		int i = 0;
		if(str.charAt(0) == '-') 
		{
			minus = true;
			i++;
		} 
		else if(str.charAt(0) == '+')
			i++;
		// 用double型来存结果
		double result = 0;
	 
		// 计算数字结果
		
		for(;i<str.length();i++)
		{
			char cur = str.charAt(i);
			if(cur >= '0' && cur <= '9')
				result = result * 10 + (str.charAt(i) - '0');
			else
				break;
		}
	 
		if(minus)
			result = -result;
	 
		// 检查是否越界
		if(result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
	 
		if(result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
	 
		return (int)result;
    }
}