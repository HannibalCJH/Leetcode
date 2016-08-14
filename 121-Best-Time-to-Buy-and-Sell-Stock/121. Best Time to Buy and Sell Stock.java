public class Solution {
    public int maxProfit(int[] prices) 
    {
        if(prices.length < 2)
            return 0;
        int curMin = prices[0], maxPro = 0;
        for(int i = 0; i < prices.length; i++)
        {
            curMin = Math.min(curMin, prices[i]);
            maxPro = Math.max(maxPro, prices[i] - curMin);
        }
        return maxPro;
    }
}