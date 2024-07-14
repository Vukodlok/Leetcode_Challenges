"""
Leetcode Challenge: Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring 
without repeating characters.

7/14/24
Mark Robuck
"""
class Solution:
    """
    Find longest substring without repeated characters.
    Args:
        s(str): provided string to check
    Returns:
        int: length of longest substring without repeated characters
    """
    def lengthOfLongestSubstring(self, s: str) -> int:
        #empty string
        if not s:
            return 0
        #dictionary for storing characters from s
        char_map = {}
        left = 0
        max_length = 0

        #loop through s looking for duplicate character in window
        for right in range(len(s)):
            if s[right] in char_map and char_map[s[right]] >= left:
                #move left pointer to after last occurrance of character
                left = char_map[s[right]] + 1
            
            #update last character position
            char_map[s[right]] = right
            #update max_length and current length
            max_length = max(max_length, right - left + 1)

        return max_length
