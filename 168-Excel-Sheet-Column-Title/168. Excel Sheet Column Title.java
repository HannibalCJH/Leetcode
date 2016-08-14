public class Solution {
    public String convertToTitle(int n) 
    {
        StringBuilder sb = new StringBuilder();
        while(n > 0)
        {
            // 字母是A~Y的情况
            int remainder = n % 26;
            n /= 26;
            // 字母是Z的情况
            if(remainder == 0)
            {
                remainder = 26;
                n--;
            }
            sb.insert(0, (char)(remainder + 'A' - 1));
        }
        return sb.toString();
    }
}