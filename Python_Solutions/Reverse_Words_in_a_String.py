"""
Leetcode Challenge: Reverse Words in a String

Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. 
The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or 
multiple spaces between two words. The returned string should 
only have a single space separating the words. 
Do not include any extra spaces.

7/6/24
Mark Robuck
"""
class Solution:
    """
    Reverse the words in a given string.
    Args:
        s(str): original string of words separated by space
    Returns:
        str: string with words in reverse order from s
    """
    def reverseWords(self, s: str) -> str:
        reverse = ""
        #split the string into words in an array
        words = s.split()
        #traverse the array backwards adding words to a new empty string
        for i in range(len(words) - 1, -1, -1):
            reverse += words[i] + " "
        #return all but the last space for correct format
        return reverse[:len(reverse)-1]
