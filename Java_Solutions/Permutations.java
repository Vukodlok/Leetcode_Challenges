/*
* Leetcode Challenge: Permutations
*
* Given an array nums of distinct integers, return all the possible 
* permutations. You can return the answer in any order.
*
* 9/11/24
* Mark Robuck
*/
import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
    * Find all permutations of a set of integers.
    * @params nums, given set of integers
    * @return list of all possible permutations of nums
    */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

        //helper function to generate permutations
        private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
            if (tempList.size() == nums.length) {
            //add current permutation to result
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                //avoid duplicates
                if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]); 
                backtrack(result, tempList, nums); 
                //remove last element
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
