/*
* Leetcode Challenge: Game of Life
*
* According to Wikipedia's article: "The Game of Life, 
* also known simply as Life, is a cellular automaton devised 
* by the British mathematician John Horton Conway in 1970."
*
* The board is made up of an m x n grid of cells, where each cell 
* has an initial state: live (represented by a 1) or dead (represented by a 0). 
* Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) 
* using the following four rules (taken from the above Wikipedia article):
* 1) Any live cell with fewer than two live neighbors dies 
* as if caused by under-population.
* 2) Any live cell with two or three live neighbors 
* lives on to the next generation.
* 3) Any live cell with more than three live neighbors dies, 
* as if by over-population.
* 4) Any dead cell with exactly three live neighbors becomes a live cell, 
* as if by reproduction.
* The next state is created by applying the above rules simultaneously 
* to every cell in the current state, where births and deaths 
* occur simultaneously. Given the current state of the m x n grid board, 
* return the next state.
*
* 7/23/24
* Mark Robuck
*/
class Solution {
    /*
    * Modify a 2D array according to game rules.
    * @params board, original state of the 2D array board
    */
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        // Define the 8 possible directions to check for neighbors
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},          {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        //iterate through board to mark cells with temporary states
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int liveNeighbors = countLiveNeighbors(board, r, c, directions, m, n);
                
                //mark cells with temporary states
                if (board[r][c] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    //live cell that will die
                    board[r][c] = -1;
                }
                if (board[r][c] == 0 && liveNeighbors == 3) {
                    //dead cell that will become live
                    board[r][c] = 2;
                }
            }
        }

        //iterate to update the board to the next state
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == -1) {
                    //live cell dies
                    board[r][c] = 0;
                }
                if (board[r][c] == 2) {
                    //dead cell becomes live
                    board[r][c] = 1;
                }
            }
        }
    }

    /*
    * helper function to count live neighbors
    * @params board, current board state
    * @params r, row index
    * @params c, column index
    * @params directions, 2D array of possible directions
    * @params m, length of row
    * @params n, length of column
    * @return count of live neighbors to current board element
    */
    private int countLiveNeighbors(int[][] board, int r, int c, int[][] directions, int m, int n) {
        int count = 0;
        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && Math.abs(board[nr][nc]) == 1) {
                count++;
            }
        }
        return count;
    }
}
