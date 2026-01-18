package LargestMagicSquare;

public class LargestMagicSquare {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // Prefix sums
        int[][] rowSum = new int[m][n + 1];
        int[][] colSum = new int[m + 1][n];
        // Build prefix sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i][j + 1] = rowSum[i][j] + grid[i][j];
                colSum[i + 1][j] = colSum[i][j] + grid[i][j];
            }
        }
        int maxSize = 1; // At least 1x1 is magic
        for (int size = 2; size <= Math.min(m, n); size++) {
            for (int i = 0; i + size <= m; i++) {
                for (int j = 0; j + size <= n; j++) {
                    if (isMagic(grid, rowSum, colSum, i, j, size)) {
                        maxSize = size;
                    }
                }
            }
        }
        return maxSize;
    }
    private boolean isMagic(int[][] grid, int[][] rowSum, int[][] colSum,
                            int r, int c, int size) {
        int target = rowSum[r][c + size] - rowSum[r][c];
        // Check rows
        for (int i = 0; i < size; i++) {
            int sum = rowSum[r + i][c + size] - rowSum[r + i][c];
            if (sum != target) return false;
        }
        // Check columns
        for (int j = 0; j < size; j++) {
            int sum = colSum[r + size][c + j] - colSum[r][c + j];
            if (sum != target) return false;
        }
        // Check main diagonal
        int diag1 = 0, diag2 = 0;
        for (int i = 0; i < size; i++) {
            diag1 += grid[r + i][c + i];
            diag2 += grid[r + i][c + size - 1 - i];
        }

        return diag1 == target && diag2 == target;
    }
    public static void main(String[] args) {
        // Example input
        int[][] grid = {
            {7, 1, 4, 5, 6},
            {2, 5, 1, 6, 4},
            {1, 5, 4, 3, 2},
            {1, 2, 7, 3, 4}
        };

        // Create Solution object
        LargestMagicSquare obj = new LargestMagicSquare();

        // Call the method
        int result = obj.largestMagicSquare(grid);

        // Print output
        System.out.println("Largest Magic Square Size: " + result);
    }
}
