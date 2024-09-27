"""
Leetcode Challenge: Longest Palindromic Substring

Given a string s, return the longest palindromic substring in s.

 9/27/24
 Mark Robuck
 """

class Solution:
    """
    Find smallest palindromic substring.
    Args:
        s(str): string string to search
    Returns:
        str: shortest palindromic substring in s
    """
    def longestPalindrome(self, s: str) -> str:
        #base case: empty string or single character
        if len(s) == 0:
            return ""
        
        start = 0
        max_length = 1
        
        #helper function to expand around center and check for palindrome
        def expandAroundCenter(left: int, right: int) -> None:
            nonlocal start, max_length
            while left >= 0 and right < len(s) and s[left] == s[right]:
                #update the longest palindrome information
                current_length = right - left + 1
                if current_length > max_length:
                    start = left
                    max_length = current_length
                left -= 1
                right += 1
        
        #expand around each character and each pair of characters
        for i in range(len(s)):
            #odd-length palindromes
            expandAroundCenter(i, i)
            #even-length palindromes
            expandAroundCenter(i, i + 1)
        
        return s[start:start + max_length]
        
