public class Solution {
    // 我的算法
	public String convertToTitle(int n) 
	{
        StringBuilder sb = new StringBuilder();
        int remainder;
        while(n > 0)
        {
        	remainder = n % 26;  // 1~25为"A"~"Y"
        	n /= 26;
        	// 0其实是"Z"
        	if(remainder == 0)
        	{
        		remainder = 26;  // 重设26为"Z"
        		n--;             // 在本来余数是0的情况下会向下一位进1，因为这个时候其实是"Z"而没有进位所以把这个1减回来
        	}
        	sb.append((char)('A' - 1 + remainder));
        }
        return sb.reverse().toString();
    } 
}