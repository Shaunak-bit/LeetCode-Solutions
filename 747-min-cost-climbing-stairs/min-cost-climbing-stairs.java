class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int [] dp= new int[cost.length+1];
        Arrays.fill(dp,-1);
        int two = helper(0,cost,dp);
        int one = helper(1,cost,dp);
        return Math.min(one,two);
    }public static int helper(int i ,int[] cost,int [] dp){
        if(i>=cost.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int oneJump = helper(i+1,cost,dp);
        int twoJump = helper(i+2,cost,dp);

        dp[i] = cost[i]+Math.min(oneJump,twoJump);
        return dp[i];


    }
}