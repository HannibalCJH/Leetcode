public class Solution {
    public boolean isPalindrome(String s) 
    {
        int left = 0, right = s.length() - 1;
        s = s.toLowerCase();
        while(left < right)
        {
            char lCh = s.charAt(left), rCh = s.charAt(right);
            if(lCh < '0' || lCh > 'z' || (lCh > '9' && lCh < 'a'))
            {
                left++;
                continue;
            }
            
            if(rCh < '0' || rCh > 'z' || (rCh > '9' && rCh < 'a'))
            {
                right--;
                continue;
            }
            
            if(lCh == rCh)
            {
                left++;
                right--;
            }
            else
                return false;
        }
        return true;
    }
}