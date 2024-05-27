"""
Leetcode Challenge: Length of Last Word

Given a string s consisting of words and spaces, return the length of the last word in the string.

4/27/24
Mark Robuck
"""
class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        """
        return the length of the last word in a string
        Args:
            s(str): given string
        Returns:
            length of the last word in the string as an integer
        """
        #split the string into 'words' and store in an array
        words = s.split()
        #grab the last index in the array
        lastWord = words[len(words)-1]
        #find the length and print the results
        return len(lastWord)
