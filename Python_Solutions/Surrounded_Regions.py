"""
Leetcode Challenge: Surrounded Regions

You are given an m x n matrix board containing letters 'X' and 'O', 
capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: The region is surrounded with 'X' cells if you can connect the 
region with 'X' cells and none of the region cells are on the edge of the board.
A surrounded region is captured by replacing all 'O's with 'X's in the 
input matrix board.

8/29/24
Mark Robuck
"""

class Solution:
    """
    Convert any surrounded values in a matrix to X's.
    Args:
        board(List[str]): original board configuration
    """
    def solve(self, board: List[List[str]]) -> None:
        #empty matrix
        if not board or not board[0]:
            return
        
        #depth-first search
        rows, cols = len(board), len(board[0])

        #DFS to mark 0s connected to border
        def dfs(r, c):
            if r < 0 or c < 0 or r >= rows or c >= cols or board[r][c] != 'O':
                return
            board[r][c] = 'B'
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)

        #check start/end of rows/columns
        for i in range(rows):
            if board[i][0] == 'O':
                dfs(i, 0)
            if board[i][cols - 1] == 'O':
                dfs(i, cols - 1)
        for j in range(cols):
            if board[0][j] == 'O':
                dfs(0, j)
            if board[rows - 1][j] == 'O':
                dfs(rows - 1, j)

        #flip 0 to X and B back to O
        for i in range(rows):
            for j in range(cols):
                if board[i][j] == 'O':
                    board[i][j] = 'X'
                elif board[i][j] == 'B':
                    board[i][j] = 'O'
