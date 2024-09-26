"""
Leetcode Challenge: Triangle

Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. 
More formally, if you are on index i on the current row, you may move 
to either index i or index i + 1 on the next row.

9/26/24
Mark Robuck
"""

class Solution:
    """
    Find the minimum path sum of a triangle array.
    Args:
        triangle(List[int]): given triangle array
    Returns:
        int: minimum path sum from top to bottom of triangle
    """
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        #start from the second-last row and move upwards
        for row in range(len(triangle) - 2, -1, -1):
            for col in range(len(triangle[row])):
                #take current element and add the min of two adjacent numbers from the row below
                triangle[row][col] += min(triangle[row + 1][col], triangle[row + 1][col + 1])
        
        return triangle[0][0]
        
