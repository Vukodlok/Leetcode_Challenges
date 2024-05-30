"""
Leetcode Challenge: Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

5/30/24
Mark Robuck
"""
class Solution:
    """
    Determine if one string is an anagram of another.

    Args:
        s(str): string tested on
        t(str): string to be tested
    Returns:
        bool: true if t is an anagram of s, false otherwise
    """
    def isAnagram(self, s: str, t: str) -> bool:
        #check for equal length
        if len(s) != len(t):
            return False
        #create an empty set and add each letter of s to the set
        letters = []
        for i in s:
            letters.append(i)
        #check each letter in t against letters
        for i in t:
            if i in letters:
                letters.remove(i)
            else:
                return False
        return True

"""
#optimal solutions make use of collections counter
    from collections import Counter
    return Counter(s) == Counter(t)
"""
