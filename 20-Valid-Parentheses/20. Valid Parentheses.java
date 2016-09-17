public class Solution {
    public boolean isValid(String s) 
    {
        if(s == null || s.length() < 1)
            return true;
        if(s.length() % 2 > 0)
            return false;
            
        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i < s.length(); i++)
        {
            char cur = s.charAt(i);
            if(cur == ')')
            {
                if(st.isEmpty() || st.pop() != '(')
                    return false;
            }
            else if(cur == '}')
            {
                if(st.isEmpty() || st.pop() != '{')
                    return false;
            }
            else if(cur == ']')
            {
                if(st.isEmpty() || st.pop() != '[')
                    return false;
            }
            else
                st.push(cur);
        }
        return st.isEmpty();
    }
}