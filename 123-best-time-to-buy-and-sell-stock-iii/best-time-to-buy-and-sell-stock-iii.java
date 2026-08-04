class Solution {
    public int maxProfit(int[] prices) {
        Integer [][][] dp = new Integer[prices.length][2][3];
        return helper(prices,0,0,2,dp);
    }public int helper(int []prices,int i,int holding,int trans,Integer[][][] dp){
        if (i >= prices.length || trans == 0) {
            return 0;
        }
         if (dp[i][holding][trans] != null) {
            return dp[i][holding][trans];
        }
        if (holding == 0) {
            int buy = -prices[i] + helper(prices, i + 1, 1, trans, dp);
            int skip = helper(prices, i + 1, 0, trans, dp);
            dp[i][holding][trans] = Math.max(buy, skip);
        } else {
            int sell = prices[i] + helper(prices, i + 1, 0, trans - 1, dp);
            int skip = helper(prices, i + 1, 1, trans, dp);
            dp[i][holding][trans] = Math.max(sell, skip);
        }
        
        return dp[i][holding][trans];
    }
}