"""
Leetcode Challenge: Minimum Window Substring

Given two strings s and t of lengths m and n respectively, 
return the minimum window substring of s such that 
every character in t (including duplicates) is included in the window. 
If there is no such substring, return the empty string "".
The testcases will be generated such that the answer is unique.

7/17/24
Mark Robuck
"""
from collections import Counter

class Solution:
    """
    find the smallest substring of a string that contains all of certain characters.
    Args:
        s(str): string to be searched
        t(str): string of characters to be found
    Returns:
        str: minimum substring from s that contains all characters from t
    """
    def minWindow(self, s: str, t: str) -> str:
        #empty s
        if not s or not t:
            return ""
        #create dictionary and pointers for sliding window
        dict_t = Counter(t)
        required = len(dict_t)
        l = 0
        r = 0
        formed = 0
        window_counts = {}
        ans = float('inf'), None, None

        #filter s with characters only in t
        filtered_s = [(i, char) for i, char in enumerate(s) if char in dict_t]

        #initialize right pointer and window counts
        while r < len(filtered_s):
            char = filtered_s[r][1]
            window_counts[char] = window_counts.get(char, 0) + 1
            
            if window_counts[char] == dict_t[char]:
                formed += 1
            
            #shrink the window from the left
            while l <= r and formed == required:
                char = filtered_s[l][1]
                end = filtered_s[r][0]
                start = filtered_s[l][0]
                
                if end - start + 1 < ans[0]:
                    ans = (end - start + 1, start, end)
                
                window_counts[char] -= 1
                if window_counts[char] < dict_t[char]:
                    formed -= 1
                
                l += 1
            
            #grow the window from the right
            r += 1
        
        return "" if ans[0] == float("inf") else s[ans[1]: ans[2] + 1]
