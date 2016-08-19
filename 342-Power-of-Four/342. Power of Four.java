public class Solution {
    public boolean isPowerOfFour(int num) 
    {
        double logAns = Math.log(num) / Math.log(4);
        return Math.abs(logAns - Math.rint(logAns))< 0.0000000001;    
    }
}