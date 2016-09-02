public class Solution {
    // 参考博文: https://www.hrwhisper.me/leetcode-water-jug-problem/
	public boolean canMeasureWater(int x, int y, int z) 
	{
        return x + y == z || (x + y > z) && z % gcd(x, y) == 0;
    }
    
	// 找最大公约数
    private int gcd(int a, int b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }
}