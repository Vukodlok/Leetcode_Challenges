"""
Leetcode Challenge: Number of Islands

Given an m x n 2D binary grid grid which represents a map of '1's (land) 
and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent 
lands horizontally or vertically. You may assume all four edges of the 
grid are all surrounded by water.

8/28/24
Mark Robuck
"""

class Solution:
    """
    Determine number of islands in a matrix.
    Args:
        grid(List[str]): 2D array of strings 1 and 0 representing islands
    Returns:
        int: number of islands in grid
    """
    def numIslands(self, grid: List[List[str]]) -> int:
        #empty grid
        if not grid:
            return 0

        #depth-first searching function
        def dfs(i, j):
            #return if out of bounds or at water
            if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or grid[i][j] == '0':
                return

            #mark the land as visited
            grid[i][j] = '0'

            #visit all orthogonal lands
            dfs(i + 1, j)
            dfs(i - 1, j)
            dfs(i, j + 1)
            dfs(i, j - 1)

        #count islands
        islands = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    dfs(i, j)
                    islands += 1
        
        return islands
