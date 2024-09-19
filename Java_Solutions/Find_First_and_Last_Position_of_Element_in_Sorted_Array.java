/*
* Leetcode Challenge: Find First and Last Position of Element in Sorted Array
*
* Given an array of integers nums sorted in non-decreasing order, 
* find the starting and ending position of a given target value.
* If target is not found in the array, return [-1, -1].
* You must write an algorithm with O(log n) runtime complexity.
*
* 9/19/24
* Mark Robuck
*/

class Solution {
    /*
    *Find the first and last position of an element in a sorted list.
    * @params nums, sorted list of integers
    * @params target, the integer to search for
    * @return all indices target is at in nums
    */
    public int[] searchRange(int[] nums, int target) {
        
        //use helper function to find leftmost bound
        int firstPos = findBound(nums, target, true);
        if (firstPos == -1) {
            //target not found
            return new int[]{-1, -1};
        }
        //use helper function to find leftmost bound
        int lastPos = findBound(nums, target, false);
        return new int[]{firstPos, lastPos};
    }
    
    //helper function to find the leftmost and rightmost occurances
    private int findBound(int[] nums, int target, boolean isFirst) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                if (isFirst) {
                    if (mid == low || nums[mid - 1] != target) {
                        return mid;
                    }
                    high = mid - 1;
                } else {
                    if (mid == high || nums[mid + 1] != target) {
                        return mid;
                    }
                    low = mid + 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
