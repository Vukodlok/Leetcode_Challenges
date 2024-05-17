class Solution:
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
