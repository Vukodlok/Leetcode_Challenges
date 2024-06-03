"""
Leetcode Challenge: Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

6/3/24
Mark Robuck
"""
class Solution:
    """
    Find the longest common prefix in a list of strings.
    Args:
        strs(List[str]): list of strings to be compared
    Returns:
        str: most common prefix, or empty string if none exist
    """
    def longestCommonPrefix(self, strs: List[str]) -> str:
        #check for empty list
        if not strs:
            return ""
        common = strs[0]
        #iterate through list of strings
        for word in strs[1:]:
            #update common to the smallest prefix by remove the last letter each iteration
            while not word.startswith(common):
                common = common[:-1]
                #if reduced to an empty string
                if not common:
                    return ""
        return common
