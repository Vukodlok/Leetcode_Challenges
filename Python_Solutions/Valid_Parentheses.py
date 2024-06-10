"""
Leetcode Challenge: Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

6/10/24
Mark Robuck
"""
class Solution:
    """
    Determine if all paentheses have been closed in order.
    Args:
        s(str): string containing parentheses to be tested
    Returns:
        bool: true if all parentheses are closed, false otherwise
    """
    def isValid(self, s: str) -> bool:
        #create dictionary of matching pairs
        matches = {')': '(', '}': '{', ']': '['}
        stack = []
        
        for char in s:
            if char in matches:
                #pop top element from stack if not empty, otherwise assign dummy value #
                if stack:
                    top_element = stack.pop()  
                else: 
                    top_element = '#'
                #check top of stack for match, return false if not matching
                if matches[char] != top_element:
                    return False
            else:
                #if opening parenthesis, push onto the stack
                stack.append(char)
        #if stack is empty, all matches were made
        return not stack

"""
Originally I thought the problem was asking for all paratheses to be closed
regardless of order.  After running test cases I realized the string will open and close
all symbols in sequence.
"""
