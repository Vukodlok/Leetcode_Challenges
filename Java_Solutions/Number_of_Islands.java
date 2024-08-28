/*
* Leetcode Challenge: Number of Islands
*
* Given an m x n 2D binary grid grid which represents a map of '1's (land) 
* and '0's (water), return the number of islands.
*
* An island is surrounded by water and is formed by connecting adjacent 
* lands horizontally or vertically. You may assume all four edges of the 
* grid are all surrounded by water.
*
* 8/28/24
* Mark Robuck
*/

class Solution {
    /*
    * Determine number of islands in a matrix.
    * @params grid, 2D array of strings 1 and 0 representing islands
    * @return number of islands in grid as integer
    */
    public int numIslands(char[][] grid) {
        //empty grid
        if (grid == null || grid.length == 0) {
            return 0;
        }

        //count islands
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

        //depth-first searching function
        private void dfs(char[][] grid, int i, int j) {
            //return if out of bounds or at water
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
            }

            //mark the land as visited
            grid[i][j] = '0';

            //visit all orthogonal lands
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
}
