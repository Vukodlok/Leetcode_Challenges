"""
Leetcode Challenge: Basic Calculator

Given a string s representing a valid expression, implement a basic 
calculator to evaluate it, and return the result of the evaluation.
Note: You are not allowed to use any built-in function which evaluates 
strings as mathematical expressions, such as eval().

8/1/24
Mark Robuck
"""
import re

class Solution:
    """
    Evaluate a string as a mathematical expression with + and -.
    Args:
        s(str): string to evaluate as a math expression
    Returns:
        int: answer to s as an integer
    """
    def calculate(self, s: str) -> int:
        stack = []
        result = 0
        current = 0
        #sign for positive or negative
        sign = 1

        #loop through array and perform operations
        for char in s:
            #build number
            if char.isdigit():
                current = current * 10 + int(char)
            #add current to result and set values
            elif char == "+":
                result += sign * current
                current = 0
                sign = 1
            #subtract current to result and set values
            elif char == "-":
                result += sign * current
                current = 0
                sign = -1
            #push sign and result to stack and set values
            elif char == "(":
                stack.append(result)
                stack.append(sign)
                result = 0
                sign = 1
            #finish current sub-expression
            elif char == ")":
                result += sign * current
                current = 0
                #pop sign before parenthesis
                result *= stack.pop()
                #pop previous result
                result += stack.pop()

        result += sign * current
        return result
