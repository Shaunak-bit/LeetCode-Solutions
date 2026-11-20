class Solution {
    public int uniquePaths(int m, int n) {
        Integer [][] dp = new Integer[m+1][n+1];
        return helper(m,n,0,0,dp);
    }public static int helper(int m ,int n , int row , int col,Integer[][]dp){
        if(row>m || col>n){
            return 0;
        }
        if(row == m-1 || col == n-1){
            return 1;
        }
        if(dp[row][col]!=null){
            return dp[row][col];
        }
        int right = helper(m,n,row+1,col,dp);
        int down = helper(m,n,row,col+1,dp);

        dp[row][col]=right+down;
        return dp[row][col];
    }
}