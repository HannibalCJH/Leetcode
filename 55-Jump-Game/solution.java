public class Solution {
    public boolean canJump(int[] A) 
    {
        if(A.length <= 1)  
            return true;
        int maxReach = 0;  
        for(int i=0;i<A.length;i++)
            if(i <= maxReach)  
            	maxReach = Math.max(maxReach, i + A[i]);  
        return maxReach >= A.length - 1;        
    }
}