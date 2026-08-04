class Solution {
    public int maxProfit(int[] prices) {
        int [] dp = new int [prices.length+1];
        Arrays.fill(dp,-1);
        return helper(prices,1,dp);
    }public int helper(int [] prices,int i,int [] dp){
        if(i>= prices.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int include = prices[i]-prices[i-1]+helper(prices,i+1,dp);
        int exclude = helper(prices,i+1,dp);
        dp[i] =  Math.max(include,exclude);
        return dp[i] ;
    }
}