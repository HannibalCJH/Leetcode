public class Solution {
    // 参考博文: http://www.cnblogs.com/grandyang/p/5411919.html
	public int integerBreak(int n) 
	{
		if(n == 2 || n == 3) 
			return n - 1;
        int res = 1;
        while(n > 4) 
        {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}