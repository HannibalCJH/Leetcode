public class Solution {
    public int strStr(String haystack, String needle) 
    {
        int start = 0;
        while(start <= haystack.length() - needle.length())
        {
            int i1 = start, i2 = 0;
            while(i2 < needle.length() && haystack.charAt(i1) == needle.charAt(i2))
            {
                i1++;
                i2++;
            }
            
            if(i2 == needle.length()) 
                return start;
            start++;
        }
        return -1;
    }
}