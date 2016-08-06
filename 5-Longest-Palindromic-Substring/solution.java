public class Solution {
    public String longestPalindrome(String s) 
    {
        if(s.length() == 0)  
            return "";  
        String result = s.substring(0,1);  
        for(int i=0;i<s.length()-1;i++)
        {  
            String temp = expandAroundCenter(s, i, i);  
            if(temp.length() > result.length())  
            	result = temp;  
            
            temp = expandAroundCenter(s, i, i + 1);  
            if(temp.length() > result.length())  
            	result = temp;  
        }  
        return result;     
    }
    
    public String expandAroundCenter(String s, int left, int right)
    {  
        int len = s.length();  
        while(left > -1 && right < len && s.charAt(left) == s.charAt(right))
        {  
            left--;  
            right++;  
        }  
        return s.substring(left + 1, right);  
    } 
}