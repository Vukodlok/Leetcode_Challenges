"""
Leetcode Challenge: Group Anagrams

Given an array of strings strs, group the anagrams together. 
You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters 
of a different word or phrase, typically using all the original 
letters exactly once.

7/24/24
Mark Robuck
"""
class Solution:
    from collections import defaultdict
    """
    Determine which strings in a list are anagrams of one another.
    Args:
        strs(List[str]): list of given strings
    Returns:
        a list from strs organized into lists of strings that are anagrams of one another
        """
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        #create a dictionary to store anagram lists
        anagrams = defaultdict(list)

        for s in strs:
            #sort the string for processing
            sorted_str = ''.join(sorted(s))
            #append original string to list corresponding to this key
            anagrams[sorted_str].append(s)

        return list(anagrams.values())
