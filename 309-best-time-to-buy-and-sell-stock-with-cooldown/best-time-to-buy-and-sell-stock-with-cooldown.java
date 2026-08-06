class Solution {
    public int maxProfit(int[] prices) {
        Integer [][][] dp = new Integer[prices.length][2][2];
        return helper(prices,0,0,0,dp);
    }public int helper(int []prices,int cool,int hold,int i,Integer[][][] dp){
        if(i>=prices.length){
            return 0;
        }
        if(dp[i][cool][hold]!=null){
            return dp[i][cool][hold];
        }
        if(cool ==1){
           return  dp[i][cool][hold]= helper(prices,0,hold,i+1,dp);
        }
        if(hold == 0){
            int buy = -prices[i]+helper(prices,0,1,i+1,dp);
            int skip = helper(prices,0,0,i+1,dp);
            dp[i][cool][hold] = Math.max(buy,skip);
            return dp[i][cool][hold];
        }else{
            int sell = prices[i]+helper(prices,1,0,i+1,dp);
            int skip = helper(prices,0,1,i+1,dp);
            dp[i][cool][hold] = Math.max(sell,skip);
            return dp[i][cool][hold];
        }

    }
}