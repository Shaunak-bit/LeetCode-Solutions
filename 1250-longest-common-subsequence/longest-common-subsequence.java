class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] dp = new Integer[text1.length()][text2.length()];
        return helper(0,0,text1,text2,dp);

    }public static int helper(int i , int j , String text1,String text2,Integer[][]dp){
        if(i>=text1.length() ||j>=text2.length()){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int include = 0;
        if(text1.charAt(i) == text2.charAt(j)){
            include = 1+helper(i+1,j+1,text1,text2,dp);
        }
        int exclude1 = helper(i+1,j,text1,text2,dp);
        int exclude = helper(i,j+1,text1,text2,dp);
        dp[i][j] =  Math.max(include,Math.max(exclude1,exclude));
        return dp[i][j];
    }
}