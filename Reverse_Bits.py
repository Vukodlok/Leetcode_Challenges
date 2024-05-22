"""
Leetcode Challenge: Reverse Bits

Reverse bits of a given 32 bits unsigned integer.

5/7/24
Mark Robuck
"""
#note: I originally thought the directions asked to flip all 0's and 1's like a bitwise not.
# That is not the case, this challenge wants the binary number returned in reverse order.
class Solution:
    """
    Reverse the order of the bits in a binary number
    Args:
        n(int): number to be reverse
    Returns:
        int: order of bits reversed from n
    """
    def reverseBits(self, n: int) -> int:
        binary = bin(n)
        reverse = 0
        #loop through the original 32 bit unsigned integer
        for i in range(32):
            #shift the bit right with >> and extract it with &
            currentBit = (n >> i) & 1
            #shift the bit left with << and set it with |
            reverse |= currentBit << (31 - i)
        return reverse
