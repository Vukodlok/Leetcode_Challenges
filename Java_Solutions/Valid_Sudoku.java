/*
* Leetcode Challenge: Valid Sudoku
*
* Determine if a 9 x 9 Sudoku board is valid. Only the filled cells 
* need to be validated according to the following rules:
* Each row must contain the digits 1-9 without repetition.
* Each column must contain the digits 1-9 without repetition.
* Each of the nine 3 x 3 sub-boxes of the grid must contain the 
* digits 1-9 without repetition.
*
* Note:
* A Sudoku board (partially filled) could be valid but 
* is not necessarily solvable.
* Only the filled cells need to be validated according to the 
* mentioned rules.
*
* 7/18/24
* Mark Robuck
*/
import java.util.HashSet;

class Solution{
    /*
    * Check if a 9x9 2D matrix uniquely contians 1-9 in each row, column, and 3x3 grid.
    * @params board, current sudoku board as 2D string array
    * @return true if current board is valid,  i.e. no duplicate values in rows, columns, or 3x3 grids; false otherwise
    */
    public boolean isValidSudoku(char[][] board) {
        //create hashmaps for tracking
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] grids = new HashSet[9];
        
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            grids[i] = new HashSet<>();
        }
        //loop through 2D grid
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (val != '.') {
                    int gridIndex = (i / 3) * 3 + j / 3;
                    //stop the loop if value is not unique
                    if (rows[i].contains(val) || cols[j].contains(val) || grids[gridIndex].contains(val)) {
                        return false;
                    }
                    //add the value to the hashmap if unique
                    rows[i].add(val);
                    cols[j].add(val);
                    grids[gridIndex].add(val);
                }
            }
        }
        return true;
    }
}
