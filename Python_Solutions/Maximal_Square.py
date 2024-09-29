"""
Leetcode Challenge: Maximal Square

Given an m x n binary matrix filled with 0's and 1's, 
find the largest square containing only 1's and return its area.

9/29/24
Mark Robuck
"""

class Solution:
    """
    Find largest square os 1s in a matrix.
    Args: 
        matrix(List(str)): matrix of 1s and 0s as strings
    Retuns:
        int: size of largest square of 1s in matrix
    """
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        #empty matrix
        if not matrix or not matrix[0]:
            return 0
        
        rows, cols = len(matrix), len(matrix[0])
        
        #create DP table with same dimensions as matrix, initialized to 0
        dp = [[0] * cols for _ in range(rows)]
        max_side = 0
        
        #iterate through the matrix
        for i in range(rows):
            for j in range(cols):
                #only check for 1 in the matrix
                if matrix[i][j] == '1':
                    if i == 0 or j == 0:
                        #first row or column can only form 1x1 squares
                        dp[i][j] = 1
                    else:
                        #update table based on min of top, left, and top-left neighbors
                        dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
                    #update max_side if the current side is larger
                    max_side = max(max_side, dp[i][j])
        
        return max_side * max_side
        
