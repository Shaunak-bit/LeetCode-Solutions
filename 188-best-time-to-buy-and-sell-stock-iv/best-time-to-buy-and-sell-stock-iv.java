class Solution {
    public int maxProfit(int k, int[] prices) {
        Integer[][][] dp = new Integer[prices.length][2][k+1];
        return helper(k,prices,0,0,dp);
    }public int helper(int trans,int [] prices,int hold,int i,Integer [][][] dp){
        if(i>=prices.length || trans ==0){
            return 0;
        }
        if(dp[i][hold][trans]!=null){
            return dp[i][hold][trans];
        }
        if(hold == 0){
            int buy = -prices[i]+helper(trans,prices,1,i+1,dp);
            int skip = helper(trans,prices,0,i+1,dp);
            dp[i][hold][trans]= Math.max(buy,skip);
            return dp[i][hold][trans];
        }else{
            int sell = prices[i]+helper(trans-1,prices,0,i+1,dp);
            int skip = helper(trans,prices,1,i+1,dp);
            dp[i][hold][trans]= Math.max(sell,skip);
            return dp[i][hold][trans];
        }

    }
}