class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(0,nums,target);
    }public static int helper(int i ,int [] nums, int diff){
        if(i== nums.length){
            if(diff == 0){
                return 1;
            }else {
                return 0;
            }
        }
        int plus = helper(i+1,nums,diff+nums[i]);
        int neg = helper(i+1,nums,diff-nums[i]);
        return plus+neg;
    }
}