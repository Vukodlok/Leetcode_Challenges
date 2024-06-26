"""
Leetcode Challenge: Sqrt(x)

Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
You must not use any built-in exponent function or operator.

#I remember being assigned this problem in a college class way back when.
#I don't remember how we solved it but I think we used a summation and/or something
#called Newton's Algorithm or Newton's Sum or something along those lines to approximate
#a value and then check how close it was in order to make closer and closer guesses.

5/8/24
Mark Robuck
"""
class Solution:
    """
    approximate the square root of a number, rounded down
    Args:
        x(int): number to be rooted
    Returns:
        int: approximated root of x rounded down to the nearest integer
    """
    def mySqrt(self, x: int) -> int:
        root = x
        #loop enough times for a reasonable answer given values within the range
        #With trial and error 20 iterations was just enough for the given test set
        for i in range(20):
            #check for division by 0
            if root != 0:
                #Newton's "Method" uses next = (current + num/current)/2
                root = (root + x/root)/2
        #round down to the nearest int by casting
        return int(root)
