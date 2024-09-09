"""
Leetcode Challenge: Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, 
return all possible letter combinations that the number could represent. 
Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) 
is given below. Note that 1 does not map to any letters.

2: abc
3: def
4: ghi
5: jkl
6: mno
7: pqrs
8: tuv
9: wxyz

9/9/24
Mark Robuck
"""

class Solution:
    """
    Find all possible letter combinations from a phone number.
    Args:
        digits(str): phone number as integers 2-9
    Returns:
        List[str]: all possible letter combinations of digits
    """
    def letterCombinations(self, digits: str) -> List[str]:
        #empty digits
        if not digits:
            return []

        #map digits to letter values
        phone = {
            "2": "abc", "3": "def", "4": "ghi", "5": "jkl",
            "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz"
        }

        #helper backtrack function
        def backtrack(index, path):
            if len(path) == len(digits):
                combinations.append(path)
                return
            for letter in phone[digits[index]]:
                backtrack(index + 1, path + letter)

        combinations = []
        backtrack(0, "")
        return combinations
