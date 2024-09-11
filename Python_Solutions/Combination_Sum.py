"""
Leetcode Challenge: Combination Sum

Given an array of distinct integers candidates and a target integer target,
 return a list of all unique combinations of candidates where the 
 chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. 
Two combinations are unique if the frequency of at least one of the 
chosen numbers is different.

The test cases are generated such that the number of unique combinations 
that sum up to target is less than 150 combinations for the given input.

9/11/24
Mark Robuck
"""

class Solution:
    """
    Given a target number, find all combinations of integers from a list that sum to the target.
    Args:
        candidates(List[int]): list of possbile integers to use in the sum
        target(int): sum to find from candidates
    Returns:
        List[int]: list of all combinations of candidates that sum to target
    """
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []

        #helper function to perform backtracking
        def backtrack(current_combination, remaining_target, start):
            if remaining_target == 0:
                result.append(list(current_combination))
                return
            elif remaining_target < 0:
                return

            #try each candidate starting from 'start'
            for i in range(start, len(candidates)):
                current_combination.append(candidates[i])
                backtrack(current_combination, remaining_target - candidates[i], i)
                #backtrack to previous state
                current_combination.pop()

        backtrack([], target, 0)
        return result
        
