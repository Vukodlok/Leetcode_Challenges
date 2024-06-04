"""
Leetcode Challenge: Is Subsequence

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by
deleting some (can be none) of the characters without disturbing the relative positions
of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec"
is not).

6/4/24
Mark Robuck
"""
class Solution:
    """
    Determine if all characters in one string are contained in another in order.
    Args:
        s(string): the substring being checked for
        t(string): the string possibly containing s
    Returns:
        boolean: true if s is contained in t, false otherwise
    """
    def isSubsequence(self, s: str, t: str) -> bool:
        #pointer for s
        sIndex = 0
        #loop through t, checking for each character in s
        for char in t:
            #if the characters match move the sIndex pointer
            if sIndex < len(s) and char == s[sIndex]:
                sIndex += 1
        #if sIndex gets to the end of s, all characters have been found
        return sIndex == len(s)
