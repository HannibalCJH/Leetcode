public class Solution {
    // 我的算法
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
        	boolean empty = st.isEmpty();
            switch(cur)
            {
            	case ')': 
            		if(empty || st.pop() != '(') return false; break;
            	case '}':
            		if(empty || st.pop() != '{') return false; break;
            	case ']':
            		if(empty || st.pop() != '[') return false; break;
            	default: st.push(cur);
            	
            }
        }
        return st.isEmpty();
    }
}