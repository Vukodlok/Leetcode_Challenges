/*
* Leetcode Challenge: Word Search
*
* Given an m x n grid of characters board and a string word, 
* return true if word exists in the grid.
*
* The word can be constructed from letters of sequentially adjacent cells, 
* where adjacent cells are horizontally or vertically neighboring. 
* The same letter cell may not be used more than once.
*
* 9/13/24
* Mark Robuck
*/

class Solution {
    private int rows;
    private int cols;
    private char[][] board;
    private String word;

    /*
    * Determine if a word exists in a word search grid.
    * @param board the board of letters for the word search
    * @param word the word to search the board for
    * @return true if the word exists in the board, false otherwise
    */
    public boolean exist(char[][] board, String word) {
        //initialize instance variables
        this.rows = board.length;
        this.cols = board[0].length;
        this.board = board;
        this.word = word;

        //try to find the word starting from every cell
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                //if the word is found, return true
                if (backtrack(r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    //helper function for backtracking
    private boolean backtrack(int r, int c, int index) {
        //base case: matched the entire word
        if (index == word.length()) {
            return true;
        }

        //check boundaries, if current cell matches the word's current character
        if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != word.charAt(index)) {
            return false;
        }

        //mark the cell as visited
        char temp = board[r][c];
        board[r][c] = '#';

        //xxplore all four directions (up, down, left, right)
        boolean found = backtrack(r + 1, c, index + 1) ||
                        backtrack(r - 1, c, index + 1) ||
                        backtrack(r, c + 1, index + 1) ||
                        backtrack(r, c - 1, index + 1);

        //restore the cell after exploring
        board[r][c] = temp;

        return found;
    }
}
