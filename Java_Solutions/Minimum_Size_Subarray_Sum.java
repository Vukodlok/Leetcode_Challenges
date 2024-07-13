/*
* Leetcode Challenge: Minimum Size Subarray Sum
*
* Given an array of positive integers nums and a positive integer target, 
* return the minimal length of a subarray whose sum is greater than 
* or equal to target. If there is no such subarray, return 0 instead.
*
* 7/13/24
* Mark Robuck
*/
class Solution{
    /*
    * Determine if a subarray calculates to a certain value.
    * @params target, the integer the subarray sum is greater than or equal to
    * @params nums, list of integers provided
    * @return minimal length of the subarray whose sum is >= target
    */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        //empty list
        if (n == 0){
            return 0;
        }
        
        //pointers using for a sliding window
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        for (int right = 0; right < n; right++){
            //sum values from left to right
            sum += nums[right];
            //check for the target and shrink sliding window
            while (sum >= target){
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE){
            return 0;
        }
        else{
            return minLen;
        }  
    }
}
