"""
Leetcode Challenge: Evaluate Reverse Polish Notation

You are given an array of strings tokens that represents 
an arithmetic expression in a Reverse Polish Notation.
Evaluate the expression. Return an integer that represents 
the value of the expression.

Note that:
The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a 
reverse polish notation. The answer and all the intermediate 
calculations can be represented in a 32-bit integer.

7/31/24
Mark Robuck
"""
class Solution:
    """
    Evaluate an expression in reverse polish notation using a stack.
    Args:
        tokens(List[str]): expression in reverse polish notation
    Returns:    
        int: value of the expression represented by tokens
    """
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []

        for token in tokens:
            #look for math operation
            if token in "+-*/":
                #pop previous two elements
                b = stack.pop()
                a = stack.pop()
                #perform the operation and push result to the stack
                if token == "+":
                    stack.append(a+b)
                elif token == "-":
                    stack.append(a-b)
                elif token == "*":
                    stack.append(a*b)
                elif token == "/":
                    stack.append(int(a/b))
        
            #if number
            else:
                stack.append(int(token))

        return stack[0]
