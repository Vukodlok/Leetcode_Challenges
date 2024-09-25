"""
Leetcode Challenge: Word Break

Given a string s and a dictionary of strings wordDict, 
return true if s can be segmented into a space-separated sequence 
of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple 
times in the segmentation.

9/25/24
Mark Robuck
"""

class Solution:
    """
    Determine if a string can be made from strings in a dictionary.
    Args:
        s(str): string to break up
        wordDict(List[str]): dictionary of string parts
    Returns:
        bool: true if s can be made up of strings from wordDict
    """
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        word_set = set(wordDict)
        dp = [False] * (len(s) + 1)
        #base case: an empty string can be segmented
        dp[0] = True  
        
        #iterate over the string
        for i in range(1, len(s) + 1):
            #check each substring from the start to the current position
            for j in range(i):
                #if substring is in wordDict and substring before is valid
                if dp[j] and s[j:i] in word_set:
                    dp[i] = True
                    break
        
        return dp[len(s)]
        
