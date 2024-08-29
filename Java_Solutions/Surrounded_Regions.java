/*
* Leetcode Challenge: Surrounded Regions
*
* You are given an m x n matrix board containing letters 'X' and 'O', 
* capture regions that are surrounded:
*
* Connect: A cell is connected to adjacent cells horizontally or vertically.
* Region: To form a region connect every 'O' cell.
* Surround: The region is surrounded with 'X' cells if you can connect the 
* region with 'X' cells and none of the region cells are on the edge of 
* the board.
* A surrounded region is captured by replacing all 'O's with 'X's in the 
* input matrix board.
*
* 8/29/24
* Mark Robuck
*/

class Solution {
    /*
    * Convert any surrounded values in a matrix to X's.
    * @params board, original board configuration as a list of stringg
    */
    public void solve(char[][] board) {
        //empty matrix
        if (board == null || board.length == 0) {
            return;
        }
        
        //depth-first search
        int rows = board.length;
        int cols = board[0].length;

        //DFS to mark 0s connected to border
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                dfs(board, i, cols - 1);
            }
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[rows - 1][j] == 'O') {
                dfs(board, rows - 1, j);
            }
        }

        //flip 0 to X and B back to O
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    //check start/end of rows/columns
    private void dfs(char[][] board, int r, int c) {
        int rows = board.length;
        int cols = board[0].length;

        if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != 'O') {
            return;
        }

        board[r][c] = 'B';  // Mark the cell as visited

        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}
