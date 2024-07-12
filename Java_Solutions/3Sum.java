/*
* Leetcode Challenge: 3Sum
*
* Given an integer array nums, return all the triplets 
* [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, 
* and nums[i] + nums[j] + nums[k] == 0.
* Notice that the solution set must not contain duplicate triplets.
*
* 7/12/24
* Mark Robuck
*/
import java.util.*;

class Solution{
    /*
    * Find all triplets in a list that sum to zero.
    * @params nums, list of integers to check
    * @return list of lists containing the indices of values with a sum of zero
    */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> zeroSums = new ArrayList<>();

        //less than 3 numbers in the list
        if (nums.length < 3){
            return zeroSums;
        }
        //create pointers
        Arrays.sort(nums);

        //loop through nums
        for (int i = 0; i < nums.length - 2; i++) {
            //skip duplicates for 1st value
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            //look for triplet zero sums
            while (left < right){
                int total = nums[i] + nums[left] + nums[right];
                if (total == 0){
                    zeroSums.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //skip duplicate values for 2nd and 3rd values
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    //move pointers
                    left++;
                    right--;
                }
                else if (total < 0){
                    left++;
                    }
                else{
                    right--;
                    }
                }
            }
        return zeroSums;
    }
}
