/*
* Leetcode Challenge: Maximum Sum Circular Subarray
*
* Given a circular integer array nums of length n, 
* return the maximum possible sum of a non-empty subarray of nums.
*
* A circular array means the end of the array connects to the 
* beginning of the array. Formally, the next element of nums[i] 
* is nums[(i + 1) % n] and the previous element of nums[i] is 
* nums[(i - 1 + n) % n].
*
* A subarray may only include each element of the fixed buffer nums 
* at most once. Formally, for a subarray nums[i], 
* nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j 
* with k1 % n == k2 % n.
*
* 9/17/24
* Mark Robuck
*/

class Solution {
    /*
    * Find max possible sum of a subarray in a circular integer array.
    * @params nums, original circular integer array
    * @return max possible sum of a subarray of nums
    */
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;

        //find maximum sum without circularity (normal Kadane's)
        int maxKadane = kadane(nums);
        
        //find minimum subarray sum (inverted Kadane's) for circular case
        int minKadane = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            //invert the array for minimum subarray sum
            nums[i] = -nums[i];
        }
        minKadane = kadane(nums);
        minKadane = -minKadane;

        //handle the case where the minimum sum is equal to total_sum
        if (totalSum == minKadane) {
            return maxKadane;
        }
        
        //return the maximum of the normal max or circular max
        return Math.max(maxKadane, totalSum - minKadane);
    }

    //helper function to find max subarray sum (Kadane's algorithm)
    int kadane(int[] arr) {
        int currentMax = arr[0];
        int maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxSum = Math.max(maxSum, currentMax);
        }
        return maxSum;
    }

}
