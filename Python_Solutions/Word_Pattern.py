"""
Leetcode Challenge: Word Pattern

Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter 
in pattern and a non-empty word in s.

6/6/24
Mark Robuck
"""
class Solution:
    """
    Determine if a string of words follows a given pattern.
    Args:
        pattern(str): the pattern to be checked for
        s(str): the string of words to check
    Returns:
        bool: true if s follows pattern, false otherwise
    """
    def wordPattern(self, pattern: str, s: str) -> bool:
        #create dictionaries
        s_in_pattern = {}
        word_in_pattern = {}
        #split s into individual words
        words = s.split()

        # If the lengths of the pattern and words don't match, return false
        if len(pattern) != len(words):
            return False
        
        for char, word in zip(pattern, words):
            #check if in s is in pattern
            if char in s_in_pattern:
                #check for match, and if not return false
                if s_in_pattern[char] != word:
                    return False
            #if no, add to dictionary
            else:
                s_in_pattern[char] = word  

            #check if word is in pattern
            if word in word_in_pattern:
                #check for match, and if not return false
                if word_in_pattern[word] != char:
                    return False
            #if no, add to dictionary
            else:
                word_in_pattern[word] = char         

        return True
