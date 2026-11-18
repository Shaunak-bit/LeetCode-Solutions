class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
        }
        Boolean [][] dp = new Boolean [nums.length+1][(sum/2)+1];
        if(sum%2!=0){
            return false;
        }
        return helper(0,sum/2,nums,dp);
    }public static boolean helper(int i , int diff, int [] nums,Boolean [][] dp){
        if(diff == 0){
            return true;
        }
         if (i >= nums.length || diff < 0) {
            return false;
        }
        if(dp[i][diff]!=null){
            return dp[i][diff];
        }
        boolean include = helper(i+1,diff-nums[i],nums,dp);
        boolean exclude = helper(i+1,diff,nums,dp);
        dp[i][diff] =  include || exclude;
        return dp[i][diff];
    }
}