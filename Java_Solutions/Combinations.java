/*
* Leetcode Challenge: Combinations
*
* Given two integers n and k, return all possible combinations 
* of k numbers chosen from the range [1, n].
* You may return the answer in any order.
*
* 9/10/24
* Mark Robuck
*/
import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
    * Find a combination of numbers within a given range.
    * @params n, first given integer from range 1-n
    * @params k, second given integer
    * @return list of pairs of integers n and k in range 1-n
    */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

        //helper function to backtrack and find combinations
        private void backtrack(int start, int n, int k, List<Integer> comb, List<List<Integer>> result) {
            //if the current combination is of length k, add to result
            if (comb.size() == k) {
            result.add(new ArrayList<>(comb));
            return;
        }
            
        //iterate over the range and build the combination
        for (int i = start; i <= n; i++) {
        comb.add(i);
        backtrack(i + 1, n, k, comb, result);
            //backtrack by removing last element
            comb.remove(comb.size() - 1);
        }
    }
}
