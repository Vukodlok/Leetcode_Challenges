/*
* Leetcode Challenge: Rotate Array
*
* Given an integer array nums, rotate the array to the right by k steps, 
* where k is non-negative.
*
* 6/24/24
* Mark Robuck
*/
import java.util.Arrays;

class Solution{
    /*
    * Rotate all elements in anarray by k steps.
    * @params nums, starting list of integers
    * Do not return anything, modify nums in-place instead.
    */
    public void rotate(int[] nums, int k) {
        //make sure k is in the bounds of nums
        int n = nums.length;
        k = k % n;
        //create an empty array
        int[] rotated = new int[n];
        //copy the values for the start of the new array
        System.arraycopy(nums, n - k, rotated, 0, k);
        //copy the values for the end of the new array
        System.arraycopy(nums, 0, rotated, k, n - k);
        //copy the comppleted rotated array back to nums
        System.arraycopy(rotated, 0, nums, 0, n);
    }
}
