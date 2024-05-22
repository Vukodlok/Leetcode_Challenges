/*
* Leetcode Challenge: Remove Element
*
* Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. 
* The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
* Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
* Change the array nums such that the first k elements of nums contain the elements which are not equal to val. 
* The remaining elements of nums are not important as well as the size of nums.
* Return k.
*
* 5/14/24
* Author: Mark Robuck
*
*/

class Solution {
    /*
    * Remove all occurrences of a value from an array
    * @param nums, integer array of numbers to be checked for val
    * @param vam, integer to be checked for in nums and removed
    * @return integer value representing the number of elements in nums not equal to val
    */
    public int removeElement(int[] nums, int val) {
        //create left and right pointers
        int left = 0;
        int right = nums.length - 1;
        //loop through initial list
        while (left <= right) {
            //check for val
            if (nums[left] == val) {
                //replace val in nums
                nums[left] = nums[right];
                right--;
            }
            else {
                left++;
            }
        }
        return left;
    }
}
