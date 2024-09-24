/*
* Leetcode Challenge: House Robber
*
* You are a professional robber planning to rob houses along a street. 
* Each house has a certain amount of money stashed, the only constraint 
* stopping you from robbing each of them is that adjacent houses have 
* security systems connected and it will automatically contact the police 
* if two adjacent houses were broken into on the same night.
*
* Given an integer array nums representing the amount of money of each 
* house, return the maximum amount of money you can rob tonight without 
* alerting the police.
*
* 9/24/24
* Mark Robuck
*/

class Solution {
    /*
    * Given a list of integers, find the max sum without using adjacent values.
    * @params nums, list of integers representing money
    * @return max sum without using adjacent values
    */
    public int rob(int[] nums) {
        //empty list
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //only one house
        if (nums.length == 1) {
            return nums[0];
        }
        
        // Initialize variables for dynamic programming
        //two house before current
        int prev2 = 0;
        //previous house
        int prev1 = 0;

        for (int num : nums) {
            //use current or skip
            int current = Math.max(prev1, prev2 + num);
            prev2 = prev1 ;
            prev1 = current;
        }

        return prev1;
        
    }
}
