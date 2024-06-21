"""
Leetcode Challenge: Plus One

You are given a large integer represented as an integer array digits, 
where each digits[i] is the ith digit of the integer. The digits are 
ordered from most significant to least significant in left-to-right order. 
The large integer does not contain any leading 0's.
Increment the large integer by one and return the resulting array of digits.

6/21/24
Mark Robuck
"""
class Solution:
    """
    Add one to a number where each digit is an element in an array.
    Args:
        digits(List[int]): large integer stored as individual digits
    Returns:
        List[int]: digits increased by one and stored as individual digits
    """
    def plusOne(self, digits: List[int]) -> List[int]:
        #repeat in reverse, as long as current index has a value of nine
        for i in range(len(digits)-1, -1, -1):
            # add one to current index
            digits[i] += 1
            #stop the process if the updated value is now 10, change the value to 0
            if digits[i] < 10:
                return digits
            digits[i] = 0
        #if we have a leading 9 and need a new place value at the front
        return [1] + digits
