"""
Leetcode Challenge: Substring with Concatenation of All Words

You are given a string s and an array of strings words. 
All the strings of words are of the same length.
A concatenated string is a string that exactly contains 
all the strings of any permutation of words concatenated.
For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", 
"cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. 
"acdbef" is not a concatenated string because it is not the 
concatenation of any permutation of words.
Return an array of the starting indices of all the concatenated substrings 
in s. You can return the answer in any order.

7/15/24
Mark Robuck
"""
from collections import Counter

class Solution:
    """
    Find the indices of substrings within a string.
    Args:
        s(str): string ti be checked
        words(List[str]): list of strings whose concatenation will be checked for within s
    Returns:
        List[int]: list of indices where the string concatenations start in s
    """
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        #empty string or list
        if not s or not words:
            return []

        word_length = len(words[0])
        total_length = word_length * len(words)
        word_count = Counter(words)
        result = []

        for i in range(word_length):
            #create sliding window
            left = i
            right = i
            current_count = Counter()
            #use sliding window to check substrings
            while right + word_length <= len(s):
                word = s[right:right + word_length]
                right += word_length
                #increment word count
                if word in word_count:
                    current_count[word] += 1
                    #check if substring has more occurrences than allowed
                    while current_count[word] > word_count[word]:
                        current_count[s[left:left + word_length]] -= 1
                        left += word_length
                    if right - left == total_length:
                        result.append(left)
                else:
                    #reset
                    current_count.clear()
                    left = right
        return result
