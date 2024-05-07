#note: I originally thought the directions asked to flip all 0's and 1's 
#like a bitwise not.
# That is not the case, this challenge wants the binary number returned in reverse order.
class Solution:
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
