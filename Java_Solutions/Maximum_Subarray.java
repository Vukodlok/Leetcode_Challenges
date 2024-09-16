/*
* Leetcode Challenge: Maximum Subarray 
*
* Given an integer array nums, find the subarray with the largest sum, 
* and return its sum.
*
* 9/16/24
* Mark Robuck
*/

class Solution {
    /*
    * Find the subarray in an array with largest sum. (Kadane's Algorithm)
    * @params nums, starting array of integers
    * @return largest sum of a subarray in nums
    */
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        
        //traverse the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            //either extend the current subarray or start new from this element
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            //update max_sum to keep track of the largest sum so far
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
