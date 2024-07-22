"""
Leetcode Challenge: Set Matrix Zeroes

Given an m x n integer matrix matrix, if an element is 0, 
set its entire row and column to 0's.
You must do it in place.

7/22/24
Mark Robuck
"""
class Solution:
    """
    If an element in a matrix is zero, set entire row/column to zero.
    Args: 
        matrix(List[List[int]]): original matrix to check
    """
    def setZeroes(self, matrix: List[List[int]]) -> None:
        #create lists of zero elements
        zeros_in_rows = set()
        zeros_in_cols = set()
        rows = len(matrix)
        cols = len(matrix[0])

        #loop through matrix searching for zeroes to add to sets
        for row in range(rows):
            for col in range(cols):
                if matrix[row][col] == 0:
                    zeros_in_rows.add(row)
                    zeros_in_cols.add(col)

        #set rows to zero if in zeros_in_rows set
        for row in zeros_in_rows:
            for col in range(cols):
                matrix[row][col] = 0

        #set columns to zero if in zeros_in_cols set
        for col in zeros_in_cols:
            for row in range(rows):
                matrix[row][col] = 0
