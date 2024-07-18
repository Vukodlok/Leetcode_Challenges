"""
Leetcode Challenge: Valid Sudoku

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells 
need to be validated according to the following rules:
Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the 
digits 1-9 without repetition.

Note:
A Sudoku board (partially filled) could be valid but 
is not necessarily solvable.
Only the filled cells need to be validated according to the 
mentioned rules.

7/18/24
Mark Robuck
"""
class Solution:
    """
    Check if a 9x9 2D matrix uniquely contians 1-9 in each row, column, and 3x3 grid.
    Args:
        board(List[List[str]]): current sudoku board as 2D string array
    Returns:
        bool: true if current board is valid,  i.e. no duplicate values in rows, columns, or 3x3 grids; false otherwise
    """
    def isValidSudoku(self, board: List[List[str]]) -> bool:

        """
        does a block contain only unique values, excluding '.'.
        Args:
            block(List[str]): current set of values to check
        Returns:
            bool: true if no duplicate values in rows, false otherwise
        """
        def is_valid_block(block: List[str]) -> bool:
                block = [num for num in block if num != '.']
                return len(block) == len(set(block))
        """
        check if a row is valid.
        Args:
            board(List[List[str]]): current sudoku board as 2D string array
        Returns:
            bool: true if no duplicate values in rows, false otherwise
        """
        def valid_row(board: List[List[str]]) -> bool:
            for row in board:
                if not is_valid_block(row):
                    return False
            return True

        """
        check if a row is valid.
        Args:
            board(List[List[str]]): current sudoku board as 2D string array
        Returns:
            bool: true if no duplicate values in columns, false otherwise
        """
        def valid_column(board: List[List[str]]) -> bool:
            for column in range(9):
                if not is_valid_block([board[row][column] for row in range(9)]):
                    return False
            return True

        """
        check if a row is valid.
        Args:
            board(List[List[str]]): current sudoku board as 2D string array
        Returns:
            bool: true if no duplicate values in 3x3 grids, false otherwise
        """
        def valid_3x3(board: List[List[str]]) -> bool:
            for row in range(3):
                for column in range(3):
                    block = [board[r][c] for r in range(row*3, (row+1)*3) for c in range(column*3, (column+1)*3)]
                    if not is_valid_block(block):
                        return False
            return True

        return valid_row(board) and valid_column(board) and valid_3x3(board)
