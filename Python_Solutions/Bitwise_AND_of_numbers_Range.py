"""
Leetcode Challenge: Bitwise AND of Numbers Range

Given two integers left and right that represent the range 
[left, right], return the bitwise AND of all numbers in this range, inclusive.

9/23/24
Mark Robuck
"""

class Solution:
    """
    Calculate bitwise AND of a range of numbers.
    Args:
        left(int): left side of the number range
        right(int): right side of the number range
    Returns:
        int: bitwise AND of the range left to right
    """
    def rangeBitwiseAnd(self, left: int, right: int) -> int:
        #keep shifting left and right to the right until they are the same
        shift = 0
        while left < right:
            left >>= 1
            right >>= 1
            shift += 1
        #shift the result back to the left by the same amount
        return left << shift
        
