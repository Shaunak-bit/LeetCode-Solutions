class Solution {
    public int rob(int[] nums) {
        if(nums.length ==1){
            return nums[0];
        }
        int[] dpA = new int[nums.length + 1];
        int[] dpB = new int[nums.length + 1];
        Arrays.fill(dpA, -1);
        Arrays.fill(dpB, -1);
        int caseA = helper(0,dpA,nums,nums.length-2);
        int caseB = helper(1,dpB,nums,nums.length-1);
        return Math.max(caseA,caseB);
        
    }public static int helper(int i ,int[] dp , int [] nums,int end){
        if(i>end){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int skip = helper(i+1,dp,nums,end);
        int rob = nums[i]+helper(i+2,dp,nums,end);
        dp[i] = Math.max(skip,rob);
        return dp[i];
    }
}