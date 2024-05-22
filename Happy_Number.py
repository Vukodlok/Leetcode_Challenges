"""
Leetcode Challenge: Happy Number

Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

5/20/24
Mark Robuck
"""
class Solution:
    """
    Replace an integer by the sum of the squares of its digits.
    Repeat until the result is either 1 or an infinite loop.
    Args:
        n(int): integer to be tested
    Returns:
        bool: true if n is a happy number by the given definition, false if not a happy number
    """
    def isHappy(self, n: int) -> bool:
        #used to store current iteration of happy number calculation
        result = n
        #used to store a set of already seen numbers from result
        repeats = set()
        #loop until result is 1 or pattern repeats
        while (result != 1 and result not in repeats):
            #add result to the reapeats set
            repeats.add(result)
            #split the number into digits
            digits = list(map(int, str(result)))
            #clear result for storing new int after calculation
            result = 0
            #perform squaring and sum
            for num in digits:
                result += num**2
        if result == 1:
            return True
        return False

'''
A more efficient end to this based on solution code I looked at afterwards would be
return result == 1
'''
