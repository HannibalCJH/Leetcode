public class Solution {
    public int compareVersion(String version1, String version2) 
    {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        
        int index = 0;
        while(index < ver1.length && index < ver2.length)
        {
            int v1 = Integer.parseInt(ver1[index]);
            int v2 = Integer.parseInt(ver2[index]);
            
            if(v1 > v2) 
                return 1;
            if(v1 < v2) 
                return -1;
            index++;
        }
        
        while(index < ver1.length)
        {
            if(Integer.parseInt(ver1[index++]) > 0)
                return 1;
        }
        
        while(index < ver2.length)
        {
            if(Integer.parseInt(ver2[index++]) > 0)
                return -1;
        }
        return 0;
    }
}