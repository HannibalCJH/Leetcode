public class Solution {
    public List<String> letterCombinations(String digits) 
    {
        LinkedList<String> ans = new LinkedList<String>();
        
        if(digits == null || digits.length() < 1)
            return ans;
        
        // 数字字母对应表
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        
        for(int i = 0; i < digits.length(); i++)
        {
            //int x = Character.getNumericValue(digits.charAt(i));
            int digit = digits.charAt(i) - '0';
            while(ans.peek().length() == i)
            {
                String t = ans.remove();
                for(char s : mapping[digit].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }
}