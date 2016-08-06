public class Solution {
    public String simplifyPath(String path) 
    {
        int length = path.length();
        if(length == 0)
            return "/";
        
        Stack<String> st = new Stack<String>();
        int i = 0;
        while(i < length)
        {
            char cur = path.charAt(i);
            if(cur == '/')
            {
                int right = i + 1;
                while(right < length && path.charAt(right) != '/') right++;
                String part = path.substring(i + 1, right);
                i = right + 1;
                // 连续两个斜杠"//"
                if(path.length() == 0)
                    continue;
                    
                if(path.equals(".."))
                {
                    if(!st.isEmpty())
                        st.pop();
                }
                else if(path.equals("."))
                    continue;
                else
                    st.push(part);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
        {
            sb.insert(0, st.pop());
            sb.insert(0, "/");
        }
        
        if(sb.length() == 0)
            return "/";
        return sb.toString();
    }
}