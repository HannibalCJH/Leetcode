public class Solution {
    public int maxProfit(int[] prices) 
    {
        if(prices.length < 2)
            return 0;
        int curMin = prices[0]; // 当前最小值
        int maxPro = 0;         // 当前最大收益
        for(int i = 0; i < prices.length; i++)
        {
            curMin = Math.min(prices[i], curMin);
            maxPro = Math.max(prices[i] - curMin, maxPro);
        }
        return maxPro;
    }
}