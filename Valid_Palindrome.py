"""
Leetcode Challenge: Valid Palindrome

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, 
it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

5/17/24
Mark Robuck
"""
class Solution:
    """
    Determine if a string is a palindrome.

    Args:
        s(str): string to be tested
    Returns:
        boolean as true if the string is a palindrome, or false if the string is not a palindrome
    """
    def isPalindrome(self, s: str) -> bool:
        #create new empty string
        newS = ""
        #remove spaces and non-alphanumeric characters with isalnum
        for i in s:
            if i.isalnum() and i != " ":
                newS += i
        #force the string to all lowercase for easier comparisons
        newS = newS.lower()
        #create left and right side pointers
        left = 0
        right = len(newS)-1
        #create true boolean flag to track palindrome status
        isPalindrome = True
        #loop to the middle
        while left <= right:
            #check if left and right are different
            if newS[left] != newS[right]:
                #if different end and set flag to false
                isPalindrome = False
                break
            #otherwise continue to next pair of characters
            right -= 1
            left += 1
        #return boolean flag
        return isPalindrome

'''After looking through other solutions I forgot Python can move backwards
using a negative slice.  My code could have been cleaned up with something like
return newS == newS[::-1]
'''
