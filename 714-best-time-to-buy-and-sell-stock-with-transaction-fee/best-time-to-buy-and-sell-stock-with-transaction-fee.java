class Solution {
    public int maxProfit(int[] prices, int fee) {
        Integer[][] dp = new Integer[prices.length][2];
        return helper(prices,fee,0,0,dp);
    }public int helper(int []prices,int fee,int hold,int i,Integer[][]dp){
        if(i>=prices.length){
            return 0;
        }
        if(dp[i][hold]!=null){
            return dp[i][hold];
        }
        if(hold == 0){
            int buy = -prices[i]+helper(prices,fee,1,i+1,dp);
            int skip = helper(prices,fee,0,i+1,dp);
            dp[i][hold] = Math.max(buy,skip);
            return dp[i][hold];
        }else{
            int sell = prices[i]-fee+helper(prices,fee,0,i+1,dp);
            int skip = helper(prices,fee,1,i+1,dp);
            dp[i][hold]= Math.max(sell,skip);
            return dp[i][hold];
        }

    }
}