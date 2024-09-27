"""
Leetcode Challenge: Unique Paths II

You are given an m x n integer array grid. There is a robot initially 
located at the top-left corner (i.e., grid[0][0]). The robot tries to 
move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot 
can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A 
path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to 
reach the bottom-right corner.

The testcases are generated so that the answer will be less than or 
equal to 2 * 109.

9/27/24
Mark Robuck
"""
from typing import List

class Solution:
    """
    Find the number of unique paths.
    Args:
        obstacleGrid(List[int]): grid with 1s as obstacles adn 0s as open path
    Returns:
        int: number of unique paths from top left to bottom right
    """
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        
        #if starting or ending position has an obstacle, return 0
        if obstacleGrid[0][0] == 1 or obstacleGrid[m-1][n-1] == 1:
            return 0
        
        #initialize the grid for dynamic programming, starting at top left
        dp = [[0] * n for _ in range(m)]
        dp[0][0] = 1 
        
        #fill the dp grid by traversing row by row
        for i in range(m):
            for j in range(n):
                if obstacleGrid[i][j] == 1:
                    #no paths if there's an obstacle
                    dp[i][j] = 0
                else:
                    if i > 0:
                        #add paths from the top
                        dp[i][j] += dp[i-1][j]
                    if j > 0:
                        #add paths from the left
                        dp[i][j] += dp[i][j-1]
        
        #the bottom-right corner contains the total number of unique paths
        return dp[m-1][n-1]
        
