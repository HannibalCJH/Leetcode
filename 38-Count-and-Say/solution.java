public class Solution {
    public String countAndSay(int n) 
    {
        // 下一次迭代时用的字符串
        String current = "1";  
        // 根据current来生成对应的字符串
        StringBuilder str = new StringBuilder("1");  
        // 迭代n次
        for(int i = 1; i < n; i++)
        {  
        	// 重置str为空字符串
        	str = new StringBuilder("");  
            int length = current.length();  
            
            for(int j = 0; j < length; j++)
            {
                // 初始化计数器
                int count = 1;  
            	// 当前的字符等于下一个字符且没有超出字符串的长度
                while(j + 1 < length && current.charAt(j) == current.charAt(j+1))
                {
                    // 下一个字符
                    j++;  
                    // 计数器加1
                    count++;  
                }  
                // 当前字符不等于下一个字符则说明当前字符的计数已经完成，把计数和字符拼接到str并重置计数器
                str.append(count);  
                str.append(current.charAt(j));  
            }  
            // 设current为str，作为下次迭代时要用的字符串
            current = str.toString();  
        }  
        return str.toString();  
    }
}