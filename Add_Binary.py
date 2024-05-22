"""
Leetcode Challenge: Add Binary

Given two binary strings a and b, return their sum as a binary string.

4/29/24
Mark Robuck
"""

class Solution:
    """
    Sum two binary strings.
    Args:
        a(str): first binary string to add
        b(str): second binary string to add
    Returns:
        str: binary sum of a and b
    """
    def addBinary(self, a: str, b: str) -> str:
        #convert strings to binary using integer casting of base 2
        binaryA = int(a, 2)
        binaryB = int(b, 2)
        #use binary addition and convert back to string
        binarySum = bin(binaryA + binaryB)
        #strip the "0b" portion from the front of the string
        result = binarySum[2:]
        return result
