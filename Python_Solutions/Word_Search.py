"""
Leetcode Challenge: Word Search

Given an m x n grid of characters board and a string word, 
return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, 
where adjacent cells are horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

9/13/24
Mark Robuck
"""
from typing import List

class Solution:
    """
    Determine if a word exists in a word search grid.
    Args:
        board(List[str]): board of letters for the word search
        word(str): word to search the board for
    Returns:
        bool: true if word exists in board, false otherwise
    """
    def exist(self, board: List[List[str]], word: str) -> bool:
        #get dimensions of the board
        rows, cols = len(board), len(board[0])

        #helper function for backtracking
        def backtrack(r, c, index):
            #base case: matched entire word
            if index == len(word):
                return True
            if r < 0 or r >= rows or c < 0 or c >= cols or board[r][c] != word[index]:
                return False

            #mark the cell as visited
            temp = board[r][c]
            board[r][c] = '#'

            #explore all four directions (up, down, left, right)
            found = (backtrack(r + 1, c, index + 1) or
                     backtrack(r - 1, c, index + 1) or
                     backtrack(r, c + 1, index + 1) or
                     backtrack(r, c - 1, index + 1))

            #restore the cell after exploring
            board[r][c] = temp

            return found

        #try to find the word starting from every cell
        for r in range(rows):
            for c in range(cols):
                #if the word is found, return True
                if backtrack(r, c, 0):
                    return True
        
        return False
        
