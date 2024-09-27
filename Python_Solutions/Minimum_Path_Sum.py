"""
Leetcode Challenge: Minimum Path Sum

Given a m x n grid filled with non-negative numbers, 
find a path from top left to bottom right, which minimizes 
the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

9/27/24
Mark Robuck
"""
from typing import List

class Solution:
    """
    Find the cheapest path for the top left to bottom right path in a grid.
    Args:
        grid(List[int]): starting grid of integers
    Returns:
        int: sum of the min path solution
    """
    def minPathSum(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])

        #iterate through the grid tracking a min path
        for i in range(m):
            for j in range(n):
                if i == 0 and j == 0:
                    #skip the starting cell, top left cell
                    continue
                elif i == 0:
                    #top from can only come from left
                    grid[i][j] += grid[i][j - 1]
                elif j == 0:
                    #first column can only come from above
                    grid[i][j] += grid[i - 1][j]
                else:
                    #take the minimum of coming from the top or left
                    grid[i][j] += min(grid[i - 1][j], grid[i][j - 1])

        return grid[-1][-1]
        
