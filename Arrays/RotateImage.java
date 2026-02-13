import java.util.LinkedList;
import java.util.Queue;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        int n = matrix[0].length-1;
        Queue<Integer> queue = new LinkedList<>();
        for (int y = 0; y <= n; y++){
            for (int x = n; x >= 0; x--){
                queue.offer(matrix[x][y]);
            }
        }
        // rotating to 90 degrees.
        for (int x = 0; x <= n; x++){
            for (int y = 0; y <= n; y++){
                matrix[x][y] = queue.poll();
            }
        }
    }
    public static void main(String[] args) {
        rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
