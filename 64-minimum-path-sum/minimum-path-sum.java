class Solution {
    public int minPathSum(int[][] grid) {
        Integer[][] dp = new Integer[grid.length][grid[0].length];
        return helper(0,0,grid,dp);
    }public static int helper(int i,int j , int[][]grid,Integer [][] dp){
       if(i>=grid.length || j>=grid[0].length){
        return Integer.MAX_VALUE;
       }
       if(i==grid.length-1 && j==grid[0].length-1){
        return grid[i][j];
       }
       if(dp[i][j]!=null){
        return dp[i][j];
       }
        
        int right = helper(i+1,j,grid,dp);
        int down = helper(i,j+1,grid,dp);

       dp[i][j] = grid[i][j]+Math.min(right,down);
       return dp[i][j];
    }
}