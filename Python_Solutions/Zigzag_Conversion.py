"""
Leetcode Challenge: Zigzag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given 
number of rows, where the first column contains all letters, 
then an upward diagonal contians the next set of letters, 
then this pattern is repeated like a backwards capital N.  

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion 
given a number of rows.

7/8/24
Mark Robuck
"""
class Solution:
    """
    Convert a string into a zigzag format like a backwards N.
    Args: 
        s(str): string to format
        numRows(int): number of rows to use for formatting
    Returns:
        str: formatted string as read from left to right
    """
    def convert(self, s: str, numRows: int) -> str:
        #only one row
        if numRows == 1:
            return s
        #create a 2D array, pointer, and flag
        zigzag = [''] * numRows
        current_row = 0
        direction_down = False
        #fill 2D array with letters from s
        for c in s:
            zigzag[current_row] += c
            #change direction if at top or bottom row
            if current_row == 0 or current_row == numRows - 1:
                direction_down = not direction_down
            if direction_down:
                current_row += 1
            else:
                current_row -= 1
        #build a new string joining the array rows and trimming spaces
        return ''.join(zigzag)
