public class Solution {
    // 我的算法
    public int maxRotateFunction(int[] A) 
    {
        if(A == null || A.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++)
            max = Math.max(rotateFunction(A, i), max);
        return max;
    }
    
    private int rotateFunction(int[] A, int startPos)
    {
        int factor = 1, sum = 0, index = startPos + 1;
        int n = A.length;
        if(index >= n)
        	index = 0;
        
        while(index != startPos)
        {
            sum += factor++ * A[index++];
            if(index >= n)
                index = 0;
        }
        return sum;
    }
}