"""
Leetcode Challenge: Climbing Stairs

You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways 
can you climb to the top?

6/22/24
Mark Robuck
"""
class Solution:
    """How many distinct ways are there to climb stairs taking 1 or 2 steps at a time.
    Args:
        n(int): number of total steps
    Returns:
        int: distinct ways to reach the end
    """
    def climbStairs(self, n: int) -> int:
        #base case
        if n == 0 or n == 1:
            return 1
        if n == 2:
            return 2
        dp = [0] * (n+1)
        dp[0] = 1
        dp[1] = 1
        #recursive case, where the next value is the sum of the previous two
        for i in range(2, n+1):
            dp[i] = dp[i - 1] + dp[i - 2]
        return dp[n]
