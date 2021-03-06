public class Solution {
    public int myAtoi(String str) 
    {
        // 剪除两边的空格
        str = str.trim();
        if(str.length() == 0)
            return 0;
            
        boolean minus = false;
        int index = 0;
        
        // 判断正负
        if(str.charAt(index) == '-')
        {
            minus = true;
            index++;
        }
        else if(str.charAt(index) == '+')
            index++;
        
        // 用double型变量来存
        double result = 0;
        for(; index < str.length(); index++)
        {
            char cur = str.charAt(index);
            if(cur >= '0' && cur <= '9')
                result = result * 10 + (cur - '0');
            else
                break;
        }
        
        if(minus)
            result = -result;
        
        if(result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)result;
    }
}