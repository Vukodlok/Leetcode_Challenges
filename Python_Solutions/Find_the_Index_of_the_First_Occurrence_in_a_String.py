"""
Leetcode Challenge: Find the Index of the First Occurrence in a String

Given two strings needle and haystack, return the index of the first occurrence of 
needle in haystack, or -1 if needle is not part of haystack.
 
5/29/24
Mark Robuck
"""
class Solution:
    """
    find the index of the first time needle appears in haystack
    Args: 
        haystack(string): string to be searched
        needle(string): string being searched for
    Returns:
        int: index of the first occurrence of needle in haystack
    """
    def strStr(self, haystack: str, needle: str) -> int:
        return haystack.find(needle)
