public class Solution {
    // 我的算法
    public int firstUniqChar(String s) 
    {
        // 记录每个字母出现的频率
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;
        // 找到第一个频率为1的字母
        for(int i = 0; i < s.length(); i++)
            if(freq[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}