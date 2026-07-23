class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        // Traverse the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // If cell is empty
                if (board[i][j] == '.') {
                    // Try all digits
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c; // Place digit

                            if (solve(board)) return true; // If it leads to solution, done
                            else board[i][j] = '.'; // Backtrack
                        }
                    }
                    return false; // No valid digit found, trigger backtrack
                }
            }
        }
        return true; // All cells filled
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // Check row and column
            if (board[row][i] == c || board[i][col] == c) return false;

            // Check 3x3 subgrid
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == c) return false;
        }
        return true;
    }
}
