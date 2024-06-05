"""
Leetcode Challenge: Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving 
the order of characters. No two characters may map to the same character, but a 
character may map to itself.

6/5/24
Mark Robuck
"""

class Solution:
    """
    Check if all occurrences of specific letters are replaced with another character, 
    maintaining order.
    Args:
        s(str): original string
        t(str): final string with replaced characters
    Returns:
        bool: true if the process can be completed (are isomorphic), false otherwise
    """
    def isIsomorphic(self, s: str, t: str) -> bool:
        #check for different lengths
        if len(s) != len(t):
            return False
        #create dictionaries for both directional checks
        s_to_t = {}
        t_to_s = {}

        #loop through strings in parallel
        for s_letter, t_letter in zip(s, t):
            #check the dictionary for s letter
            if s_letter in s_to_t:
                #check if key values in dictionary match for s to t
                if s_to_t[s_letter] != t_letter:
                    return False
            #add to the dictionary if not present
            else:
                s_to_t[s_letter] = t_letter

            #check the dictionary for t letter
            if t_letter in t_to_s:
                #check if key values in dictionary match for t to s
                if t_to_s[t_letter] != s_letter:
                    return False
            #add to the dictionary if not present
            else:
                t_to_s[t_letter] = s_letter

        #all key values match        
        return True
