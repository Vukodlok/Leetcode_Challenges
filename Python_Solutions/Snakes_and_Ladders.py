"""
Leetcode Challenge: Snakes and Ladders

You are given an n x n integer matrix board where the cells are 
labeled from 1 to n2 in a Boustrophedon style starting from the 
bottom left of the board (i.e. board[n - 1][0]) and alternating 
direction each row.

You start on square 1 of the board. In each move, starting from square 
curr, do the following:

Choose a destination square next with a label in the range 
[curr + 1, min(curr + 6, n2)].
This choice simulates the result of a standard 6-sided die roll: i.e., 
there are always at most 6 destinations, regardless of the size of the board.
If next has a snake or ladder, you must move to the destination of that 
snake or ladder. Otherwise, you move to next.
The game ends when you reach the square n2.

A board square on row r and column c has a snake or ladder 
if board[r][c] != -1. The destination of that snake or ladder 
is board[r][c]. Squares 1 and n2 are not the starting points 
of any snake or ladder.

Note that you only take a snake or ladder at most once per move. 
If the destination to a snake or ladder is the start of another 
snake or ladder, you do not follow the subsequent snake or ladder.

For example, suppose the board is [[-1,4],[-1,3]], and on the first 
move, your destination square is 2. You follow the ladder to square 3, 
but do not follow the subsequent ladder to 4.
Return the least number of moves required to reach the square n2. If it 
is not possible to reach the square, return -1.

9/3/24
Mark Robuck
"""
from collections import deque
from typing import List

class Solution:
    """
    Determine the minimum number of moves to reach the end of a snakes and ladders board.
    Args:
        board(List[int]): board configuration
    Returns:
        int: minimum number of moves to reach the end of board
    """
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        n = len(board)

        """
        Convert the square number s to (r, c) in the board
        Args:
            s(int): square number
        Returns:
            (int, int): rows and columns
        """
        def get_position(s: int) -> (int, int):
            quot, rem = divmod(s - 1, n)
            row = n - 1 - quot
            col = rem if quot % 2 == 0 else n - 1 - rem
            return row, col

        #track visited nodes
        visited = set()
        queue = deque([(1, 0)])
        
        #simulate possible moves, adjusting for snakes and ladders
        while queue:
            curr, moves = queue.popleft()
            for i in range(1, 7):
                next_square = curr + i
                if next_square > n * n:
                    continue
                
                r, c = get_position(next_square)
                if board[r][c] != -1:
                    next_square = board[r][c]
                
                if next_square == n * n:
                    return moves + 1
                
                if next_square not in visited:
                    visited.add(next_square)
                    queue.append((next_square, moves + 1))
        
        return -1
        
