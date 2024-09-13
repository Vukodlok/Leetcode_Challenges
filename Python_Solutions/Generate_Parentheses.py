"""
Leetcode Challenge: Generate Parentheses

Given n pairs of parentheses, write a function to generate all 
combinations of well-formed parentheses.

9/13/24
Mark Robuck
"""
from typing import List

class Solution:
    """
    Find all possible combinations of properly formatted parentheses.
    Args:
        n(int): number of pairs of parentheses
    Returns:
        List(str): all possible combinations of formatted parentheses
    """
    def generateParenthesis(self, n: int) -> List[str]:
        result = []
        
        #helper function for backtracking
        def backtrack(s='', open_count=0, close_count=0):
            #base case: valid combination
            if len(s) == 2 * n:
                result.append(s)
                return
            
            #add an open parenthesis if we haven't reached the limit
            if open_count < n:
                backtrack(s + '(', open_count + 1, close_count)
            
            #add a closing parenthesis if there are open parentheses to close
            if close_count < open_count:
                backtrack(s + ')', open_count, close_count + 1)
        
        #start backtracking from an empty string
        backtrack()
        return result
        
