"""
Leetcode Challenge: Interleaving String

Given strings s1, s2, and s3, find whether s3 is formed by 
an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where 
s and t are divided into n and m substrings respectively, such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... 
or t1 + s1 + t2 + s2 + t3 + s3 + ...

Note: a + b is the concatenation of strings a and b.

9/27/24
Mark Robuck
"""

class Solution:
    """
    Can a string be formed by weaving two other strings together.
    Args:
        s1(str): given substring
        s2(str): given substring
        s3(str): interleaving string formed with s1 and s2
    Returns:
        bool: true if s3 can be made of s1 and s2, false otherwise
    """
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        #base case: if lengths of s1 + s2 don't match s3, not possible
        if len(s1) + len(s2) != len(s3):
            return False
        
        #initialize a 2D DP table
        dp = [[False] * (len(s2) + 1) for _ in range(len(s1) + 1)]
        
        #set dp[0][0] to True (empty strings match)
        dp[0][0] = True
        
        #fill the table
        for i in range(len(s1) + 1):
            for j in range(len(s2) + 1):
                #check if the current position can be reached by either s1 or s2
                if i > 0 and s1[i - 1] == s3[i + j - 1]:
                    dp[i][j] |= dp[i - 1][j]
                if j > 0 and s2[j - 1] == s3[i + j - 1]:
                    dp[i][j] |= dp[i][j - 1]
        
        return dp[-1][-1]
        
