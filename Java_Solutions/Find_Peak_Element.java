/*
* Leetcode Challenge: Find Peak Element 
*
* A peak element is an element that is strictly greater than its neighbors.
* Given a 0-indexed integer array nums, find a peak element, 
* and return its index. If the array contains multiple peaks, 
* return the index to any of the peaks.
*
* You may imagine that nums[-1] = nums[n] = -∞. In other words, 
* an element is always considered to be strictly greater than a 
* neighbor that is outside the array.
*
* You must write an algorithm that runs in O(log n) time.
*
* 9/18/24
* Mark Robuck
*/

class Solution {
    /*
    * Find a peak element, an element strictly greater than its neighbors.
    * @params nums, list of integers to be searched
    * @return the index of any peak element in nums
    */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;

            //compare middle element to right neighbor
            if (nums[mid] < nums[mid + 1]) {
                //peak must be on right side
                left = mid + 1;
            } else {
                //peak must be at left side or middle
                right = mid;
            }
        }

        //the peak is where left == right
        return left;
        
    }
}
