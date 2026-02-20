package DynamicProgramming;

public class UniquePath {
    int[][] dp;
    int  findPaths(int m, int n, int i, int j, int[][] dp){
        if (i == m && j == n) return 1;
        if (i > m || j > n) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int downPaths = findPaths(m, n, i + 1, j, dp);
        int rightPaths = findPaths(m, n, i, j + 1, dp);
        dp[i][j] = downPaths + rightPaths;
        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        return findPaths(m-1, n-1, 0, 0, dp);
    }

    public static void main(String[] args) {
        UniquePath path = new UniquePath();
        System.out.println(path.uniquePaths(3, 7));
    }
}
