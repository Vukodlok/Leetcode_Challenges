"""
Leetcode Challenge: Combinations

Given two integers n and k, return all possible combinations 
of k numbers chosen from the range [1, n].
You may return the answer in any order.

9/10/24
Mark Robuck
"""

class Solution:
    """
    Find a combination of numbers within a given range.
    Args:
        n(int): first given number from range 1-n
        k(int): second given number
    Returns:
        List[int]: list of pairs of integers n and k in range 1-n
    """
    def combine(self, n: int, k: int) -> List[List[int]]:
        result = []

        #helper function to backtrack and find combinations
        def backtrack(start, comb):
            #if the current combination is of length k, add to result
            if len(comb) == k:
                result.append(list(comb))
                return
            
            #iterate over the range and build the combination
            for i in range(start, n + 1):
                comb.append(i)
                backtrack(i + 1, comb)
                #backtrack by removing last element
                comb.pop()

        backtrack(1, [])
        return result
