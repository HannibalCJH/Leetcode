public class Solution {
    public String countAndSay(int n) 
    {
        // current is the string for next iteration to count
        String current = "1";  
        // str is for building new string in terms of current
        StringBuilder str = new StringBuilder("1");  
        // index of nth sequence
        for(int i=1;i<n;i++)
        {  
        	// reset str as empty string
        	str = new StringBuilder("");  
            int length = current.length();  
            // initialze count
            int count = 1;  
            for(int j=0;j<length;j++)
            {  
            	// while current char equals to next char and the index is within length,
            	// increase count and move to next index
                while(j + 1 < length && current.charAt(j) == current.charAt(j+1))
                {  
                    j++;  
                    count++;  
                }  
                // while current char differs from next char, so the count of current char is over,
                // append count and char then reset count to 1 for counting another char
                str.append(count);  
                str.append(current.charAt(j));  
                count = 1;  
            }  
            // store str in current for counting in next iteration 
            current = str.toString();  
        }  
        return str.toString();  
    }
}