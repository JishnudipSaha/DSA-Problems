package DynamicProgramming;

public class UniquePathThree {
    int dfs(int[][] grid, int i, int j, int zero){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1){
            return 0;
        }

        if (grid[i][j] == 2)
            return zero == -1? 1 : 0;

        grid[i][j] = -1; // marking the visited cell as -1
        zero--;

        int totalPaths = dfs(grid, i + 1, j, zero) + // down
                dfs(grid, i, j + 1, zero) + // right
                dfs(grid, i - 1, j, zero) + // up
                dfs(grid, i, j - 1, zero); // left

        // backtrack
        grid[i][j] = 0;
        zero++;

        return totalPaths;
    }
    public int uniquePathsIII(int[][] grid) {
        int zeroCount = 0;
        int sx = 0, sy = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 0) zeroCount++;
                if (grid[i][j] == 1){
                    sx = i;
                    sy = j;
                }
            }
        }
        return dfs(grid, sx, sy, zeroCount);
    }

    public static void main(String[] args) {
        // code for the function
    }
}
