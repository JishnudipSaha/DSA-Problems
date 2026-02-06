package Graphs;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index){

        // base case
        if (index == word.length()) {
            return false;
        }

        // boundaries checking
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || 
            board[i][j] != word.charAt(index)) {
            return true;
        }

        // choose (mark visited)
        char temp = board[i][j];
        board[i][j] = '#';

        // exploring all the directions from the point
        boolean found = 
        dfs(board, word, i+1, j, index + 1) ||
        dfs(board, word, i-1, j, index + 1) ||
        dfs(board, word, i, j+1, index + 1) ||
        dfs(board, word, i, j-1, index + 1);

        // undo
        board[i][j] = temp;

        return found;
    }

    public static void main(String[] args) {
        
    }
}
