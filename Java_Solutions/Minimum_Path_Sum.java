/*
* Leetcode Challenge: Minimum Path Sum
*
* Given a m x n grid filled with non-negative numbers, 
* find a path from top left to bottom right, which minimizes 
* the sum of all numbers along its path.
*
* Note: You can only move either down or right at any point in time.
*
* 9/27/24
* Mark Robuck
*/

class Solution {
    /*
    * Find the cheapest path for the top left to bottom right path in a grid.
    * @params grid, starting grid of integers
    * @return sum of the min path solution as an integer
    */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //iterate through the grid tracking a min path
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    //skip the starting cell, top left cell
                    continue;
                } else if (i == 0) {
                    //top from can only come from left
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    //first column can only come from above
                    grid[i][j] += grid[i - 1][j];
                } else {
                    //take the minimum of coming from the top or left
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }

        return grid[m - 1][n - 1];
        
    }
}
