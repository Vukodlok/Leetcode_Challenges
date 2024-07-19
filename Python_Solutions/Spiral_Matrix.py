"""
Leetcode Challenge: Spiral Matrix

Given an m x n matrix, return all elements of the matrix in 
spiral clockwise order.

7/19/24
Mark Robuck
"""
class Solution:
    """
    Return a list of elements from a matrix in a specific order
    Args:
        matrix(List[List[int]]): original 2D array (matrix)
    Returns:
        list in spiral clockwise order
    """
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        #empty matrix or single row
        if not matrix or not matrix[0]:
            return []

        result = []

        #create pointers
        top = 0
        left = 0
        bottom = len(matrix) - 1
        right = len(matrix[0]) - 1

        #repeat until boundaries overlap
        while top <= bottom and left <= right:
            #traverse left to right
            for i in range(left, right + 1):
                result.append(matrix[top][i])
            #move down one row
            top += 1
            #traverse top to bottom
            for i in range(top, bottom + 1):
                result.append(matrix[i][right])
            #move left one column
            right -= 1

            if top <= bottom:
            #traverse right to left
                for i in range(right, left - 1, -1):
                    result.append(matrix[bottom][i])
                #move up one row
                bottom -= 1

            if left <= right:
                #traverse bottom to top
                for i in range(bottom, top - 1, -1):
                    result.append(matrix[i][left])
                #move right one column
                left += 1

        return result
