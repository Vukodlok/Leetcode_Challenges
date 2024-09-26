/*
* Leetcode Challenge: Longest Increasing Subsequence
* 
* Given an integer array nums, return the length of the longest 
* strictly increasing subsequence.
*
* 9/26/24
* Mark Robuck
*/

class Solution {
    /*
    * Find length of longest increasing subsequence in an array.
    * @params nums, array of integers to check
    * @return length of longest strictly increasing subarray of nums
    */
    public int lengthOfLIS(int[] nums) {
        //base case: empty list
        if (nums.length == 0) {
            return 0;
        }
        
        //array to store length of the LIS at each index
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        
        //iterate through nums to fill the dp array
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 1;
        for (int length : dp) {
            max = Math.max(max, length);
        }
        
        return max;
    }
}
