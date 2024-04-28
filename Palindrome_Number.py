class Solution:
    def isPalindrome(self, x: int) -> bool:
        #ignore negatives since they are not palindromes by the challenge description
        if x < 0:
            return False
        else:
            #create an array filled with the digits of the number
            num = x
            i = 0
            digits = []
            while num > 0:
                digits.append(num % 10)
                num = (int)(num / 10)
                i += 1
            #create a left and right side tracking variable
            left = 0
            right = len(digits)-1
            isPalindrome = True
            #loop through given number to the center
            for i in range((int)(len(digits)/2)):
                #check the left and right side against each other
                if digits[left] == digits[right]:
                    #if numbers are equal move left and right one spot and continue
                    left += 1
                    right -= 1
                #if numbers are not equal break the loop and end
                else:
                    isPalindrome = False
            return isPalindrome
