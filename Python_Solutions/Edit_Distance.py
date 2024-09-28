"""
Leetcode Challenge: Edit Distance

Given two strings word1 and word2, return the minimum number 
of operations required to convert word1 to word2.

You have the following three operations permitted on a word:
Insert a character
Delete a character
Replace a character

9/28/24
Mark Robuck
"""

class Solution:
    """
    Find minimum number of operations to convert word1 into word2.
    Args:
        word1(str): starting word
        word2(str): ending word
    Returns:
        int: minimum number of operations to convert word1 into word2
    """
    def minDistance(self, word1: str, word2: str) -> int:
        #initialize a 2D DP array
        m, n = len(word1), len(word2)
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        
        #base case: converting empty string to any string
        for i in range(m + 1):
            dp[i][0] = i
        for j in range(n + 1):
            dp[0][j] = j
        
        #fill the DP table
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if word1[i - 1] == word2[j - 1]:
                    #no change needed if the characters are the same
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = 1 + min(dp[i - 1][j],   #delete
                                       dp[i][j - 1],   #insert
                                       dp[i - 1][j - 1])  #replace
        
        return dp[m][n]
        
