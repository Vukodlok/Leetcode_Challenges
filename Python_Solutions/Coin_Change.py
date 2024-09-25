"""
Leetcode Challenge: Coin Change

You are given an integer array coins representing coins of different 
denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of 
the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

9/25/24
Mark Robuck
"""

class Solution:
    """
    Determine the fewest number of coins to make change.
    Args:
        coins(List[int]): list of coin denominations
        amount(int): integer representing amount of money
    Returns:
        int: fewest number of coins needed, or -1 if not possible
    """
    def coinChange(self, coins: List[int], amount: int) -> int:
        #dp[i] represents the minimum coins required to make amount i
        dp = [float('inf')] * (amount + 1)
        #base case: to make 0 amount, 0 coins are needed
        dp[0] = 0 
        
        #iterate over each amount from 1 to amount
        for i in range(1, amount + 1):
            for coin in coins:
                if i - coin >= 0:
                    dp[i] = min(dp[i], dp[i - coin] + 1)
        
        #if dp[amount] is still infinity, not possible to make amount
        return dp[amount] if dp[amount] != float('inf') else -1
        
