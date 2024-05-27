"""
Leetcode Challenge: Ransom Note

Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

4/30/24
Mark Robuck
"""
class Solution:
    """
    Determine if all characters in a string are contained within another string.
    Args:
        ransomNote(str): the string to be tested if all character are also within magazine
        magazine(str): the string to be used to test if all characters from ransomNote are within it
    Returns:
        bool: returns true if all characters in ransomNote are within magazine, and false if not
    """
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        containsAll = True
        #create an array for each string containing each letter using split
        ransomLetters = list(ransomNote)
        magazineLetters = list(magazine)
        #loop through ransom array
        for i in ransomLetters:
            #check to see if each letter in ransom is in magazine
            if i in magazineLetters:
                #if yes remove it from magazine
                magazineLetters.remove(i)
                #if reach end of loop return true
            else:
            #if check is false return false
                containsAll = False
        return containsAll

#An interesting side note I found after reviewing some of the other solutions submitted.  Removing my flag variable and replacing lines 16 and 17 with return true/false yields a runtime of half the time my solution ran in.
