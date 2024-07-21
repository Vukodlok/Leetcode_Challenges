"""
Leetcode Challenge: Rotate Image

You are given an n x n 2D matrix representing an image, 
rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means 
you have to modify the input 2D matrix directly. DO NOT allocate 
another 2D matrix and do the rotation.

7/21/24
Mark Robuck
"""
class Solution:
    """
    Rotate the elements of a matrix 90 degrees clockwise.
    Args: 
        matrix(List[List[int]]): original matrix representing an image
    """
    def rotate(self, matrix: List[List[int]]) -> None:
        #copy the rows from original into the columns of new
        n = len(matrix)
        
        # Step 1: Transpose the matrix
        for i in range(n):
            for j in range(i + 1, n):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        
        # Step 2: Reverse each row
        for i in range(n):
            matrix[i].reverse()
