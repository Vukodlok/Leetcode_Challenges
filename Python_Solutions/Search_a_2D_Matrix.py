"""
Leetcode Challenge: Search a 2D Matrix

You are given an m x n integer matrix matrix with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer 
of the previous row.

Given an integer target, return true if target is in matrix or false otherwise.
You must write a solution in O(log(m * n)) time complexity.

9/17/24
Mark Robuck
"""

class Solution:
    """
    Determine if an integer is in a matrix.
    Args:
        matrix(List[int]): 2D matrix of integers
        target(int): integer to search matrix for
    Returns:
        bool: true if target exists in matrix, false otherwise
    """
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        #empty matrix
        if not matrix or not matrix[0]:
            return False
        
        #binary search
        m, n = len(matrix), len(matrix[0])
        left, right = 0, m * n - 1
        
        while left <= right:
            mid = (left + right) // 2
            mid_value = matrix[mid // n][mid % n]
            
            if mid_value == target:
                return True
            elif mid_value < target:
                left = mid + 1
            else:
                right = mid - 1
        
        return False
        
