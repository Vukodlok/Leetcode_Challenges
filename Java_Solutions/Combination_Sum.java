/*
* Leetcode Challenge: Combination Sum
*
* Given an array of distinct integers candidates and a target integer target,
* return a list of all unique combinations of candidates where the 
* chosen numbers sum to target. You may return the combinations in any order.
*
* The same number may be chosen from candidates an unlimited number of times. 
* Two combinations are unique if the frequency of at least one of the 
* chosen numbers is different.
*
* The test cases are generated such that the number of unique combinations 
* that sum up to target is less than 150 combinations for the given input.
*
* 9/11/24
* Mark Robuck
*/
import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
    * Given a target number, find all combinations of integers from a list that sum to the target.
    * @params candidates, list of possbile integers to use in the sum
    * @params target, sum to find from candidates
    * @return list of all combinations of candidates that sum to target
    */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    //helper function to perform backtracking
    private void backtrack(List<List<Integer>> result, List<Integer> currentCombination, int[] candidates, int remainingTarget, int start) {
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(currentCombination));
        } else if (remainingTarget > 0) {
            for (int i = start; i < candidates.length; i++) {
                currentCombination.add(candidates[i]);
                backtrack(result, currentCombination, candidates, remainingTarget - candidates[i], i);
                //backtrack
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }
}
