'''
# Leetcode challenge: Number of 1 Bits
#
# Write a function that takes the binary representation of a positive integer
# and returns the number of set bits it has (also known as the Hamming weight).
#
# Created 5/21/24
# Author: Mark Robuck
'''

class Solution:
    '''
    # Find the hamming weight of an integer n, n is assumed to be a positive integer
    @param n, positive integer to have hamming weight calculated of
    @return int, hamming weight of integer n
    '''
    def hammingWeight(self, n: int) -> int:
        #convert int to binary string
        return bin(n).count('1')
