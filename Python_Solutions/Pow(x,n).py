"""
Leetcode Challenge: Pow(x,n)

Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).

5/27/24
Mark Robuck
"""

class Solution:
    """
    Calculates an exponent.

    Args:
        x(float): base
        n(int): power/exponent
    Returns:
        float: result of x to the n power
    """
    def myPow(self, x: float, n: int) -> float:
        # Base case: any number to the power of 0 is 1
        if n == 0:
            return 1  
        # If n is negative, invert x and make n positive
        if n < 0:
            x = 1 / x
            n = -n
        # Recursively reduce n by half in order to create smaller subproblems
        half = self.myPow(x, n // 2)
        # If n is even
        if n % 2 == 0:
            return half * half
        # If n is odd
        else:
            return half * half * x

"""
My original solution involved a loop and timed out on some of the unit tests.
        answer = 1
        if n >= 0:
            for i in range(n):
                answer *= x
            return answer
        else:
            for i in range(-1*n):
                answer *= x
            return 1.0/answer
"""

"""
return x**n is an optimal solution submitted by others, but I assumed by the description
of the problem this was not allowed.
"""
