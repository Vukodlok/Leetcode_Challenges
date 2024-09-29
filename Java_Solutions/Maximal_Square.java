/*
* Leetcode Challenge: Maximal Square
*
* Given an m x n binary matrix filled with 0's and 1's, 
* find the largest square containing only 1's and return its area.
*
* 9/29/24
* Mark Robuck
*/

class Solution {
    /*
    * Find largest square os 1s in a matrix.
    * @params matrix, matrix of 1s and 0s as strings
    * @return size of largest square of 1s in matrix
    */
    public int maximalSquare(char[][] matrix) {
        //empty matrix
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int rows = matrix.length, cols = matrix[0].length;
        
        //create DP table with same dimensions as matrix, initialized to 0
        int[][] dp = new int[rows][cols];
        int maxSide = 0;
        
        //iterate through the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //only check for 1 in the matrix
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        //first row or column can only form 1x1 squares
                        dp[i][j] = 1;
                    } else {
                        //update table based on min of top, left, and top-left neighbors
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    //update max_side if the current side is larger
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        
        return maxSide * maxSide;
    }
}
