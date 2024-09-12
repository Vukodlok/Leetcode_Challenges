"""
Leetcode Challenge: N-Queens II

The n-queens puzzle is the problem of placing n queens 
on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the 
n-queens puzzle.

9/12/24
Mark Robuck
"""

class Solution:
    """
    Find the number of distinct solutions to the n-queens puzzle.
    Args:
        n(int): number of queens and side length of the board
    Returns:
        int: number of distinct solutions
    """
    def totalNQueens(self, n: int) -> int:
        def backtrack(row, diagonals, anti_diagonals, cols):
            #single queen/square board
            if row == n:
                return 1
            solutions = 0

            #find a solution
            for col in range(n):
                curr_diagonal = row - col
                curr_anti_diagonal = row + col
                if col in cols or curr_diagonal in diagonals or curr_anti_diagonal in anti_diagonals:
                    continue
                cols.add(col)
                diagonals.add(curr_diagonal)
                anti_diagonals.add(curr_anti_diagonal)
                #add new solutions to the count
                solutions += backtrack(row + 1, diagonals, anti_diagonals, cols)
                cols.remove(col)
                diagonals.remove(curr_diagonal)
                anti_diagonals.remove(curr_anti_diagonal)
            return solutions
        
        return backtrack(0, set(), set(), set())

        
