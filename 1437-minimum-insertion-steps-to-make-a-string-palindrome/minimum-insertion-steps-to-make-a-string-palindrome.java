class Solution {
    public int minInsertions(String s) {
        Integer[][] dp = new Integer[s.length()][s.length()];
        return helper(0,s.length()-1,s,dp);
    }public static int helper(int left , int right , String s,Integer[][] dp){
        if(left>=right){
            return 0;
        }
        if(dp[left][right]!=null){
            return dp[left][right];
        }
        
        if(s.charAt(left)==s.charAt(right)){
            dp[left][right] =  helper(left+1,right-1,s,dp);
            return dp[left][right];
        }
        int insertleft = helper(left+1,right,s,dp);
        int insertright = helper(left,right-1,s,dp); 
        dp[left][right] = 1+Math.min(insertleft,insertright);
        return dp[left][right];
    }
}