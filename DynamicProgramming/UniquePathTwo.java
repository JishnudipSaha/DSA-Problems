package DynamicProgramming;

public class UniquePathTwo {
    int[][] dp;
    int countUniquePaths(int[][] obstacleGrid,int[][] dp, int m, int n, int i, int j){
        if (i>m || j>n) return 0;
        if (obstacleGrid[i][j] == 1) return 0;
        if (i == m && j == n) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        int downPaths = countUniquePaths(obstacleGrid, dp, m, n, i+1, j);
        int rightPaths = countUniquePaths(obstacleGrid, dp, m, n, i, j+1);
        dp[i][j] = downPaths + rightPaths;
        return dp[i][j];

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;
        dp = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        return countUniquePaths(obstacleGrid, dp, m-1, n-1, 0, 0);
    }
}
