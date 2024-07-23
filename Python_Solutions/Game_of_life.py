"""
Leetcode Challenge: Game of Life

According to Wikipedia's article: "The Game of Life, also known simply as Life, 
is a cellular automaton devised by the British mathematician 
John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell 
has an initial state: live (represented by a 1) or dead (represented by a 0). 
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) 
using the following four rules (taken from the above Wikipedia article):
1) Any live cell with fewer than two live neighbors dies 
as if caused by under-population.
2) Any live cell with two or three live neighbors 
lives on to the next generation.
3) Any live cell with more than three live neighbors dies, 
as if by over-population.
4) Any dead cell with exactly three live neighbors becomes a live cell, 
as if by reproduction.
The next state is created by applying the above rules simultaneously 
to every cell in the current state, where births and deaths 
occur simultaneously. Given the current state of the m x n grid board, 
return the next state.

7/23/24
Mark Robuck
"""
class Solution:
    """
    Modify a 2D array according to game rules.
    Args:
        board(List[List[int]]): original state of the 2D array board
    """
    def gameOfLife(self, board: List[List[int]]) -> None:
        m = len(board)
        n = len(board[0])

        #check the state of all 8 adjacent cells, and return count
        def count_neighbors(r, c) -> int:
            """
            Count the number of live neighbors
            Args: 
                r(int): row index
                c(int): column index
            Returns: 
                count of integer number of live neighbors
            """
            directions = [(-1, -1), (-1, 0), (-1, 1),
                          (0, -1),           (0, 1),
                          (1, -1), (1, 0), (1, 1)]
            #track number of live neighbors, 1 or -1
            count = 0
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if 0 <= nr < m and 0 <= nc < n and abs(board[nr][nc]) == 1:
                    count += 1
            return count

        #iterate through the board and set values based on count_neighbors
        for r in range(m):
            for c in range(n):
                live_neighbors = count_neighbors(r, c)
                
                if board[r][c] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                    #mark as -1 to indicate the cell is currently live but will die
                    board[r][c] = -1 
                if board[r][c] == 0 and live_neighbors == 3:
                    #mark as 2 to indicate the cell is currently dead but will live
                    board[r][c] = 2

        #update board for next round
        for r in range(m):
            for c in range(n):
                if board[r][c] == -1:
                    #live cell dies
                    board[r][c] = 0
                if board[r][c] == 2:
                    #dead cell becomes live
                    board[r][c] = 1
