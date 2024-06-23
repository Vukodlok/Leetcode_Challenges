/*
* Leetcode Challenge: Remove Duplicates from Sorted Array II
*
* Given an integer array nums sorted in non-decreasing order, remove some duplicates 
* in-place such that each unique element appears at most twice. The relative order 
* of the elements should be kept the same.
*
* Since it is impossible to change the length of the array in some languages, you must 
* instead have the result be placed in the first part of the array nums. More formally, 
* if there are k elements after removing the duplicates, then the first k elements of nums 
* should hold the final result. It does not matter what you leave beyond the 
* first k elements.
*
* Return k after placing the final result in the first k slots of nums.
* Do not allocate extra space for another array. You must do this by modifying 
* the input array in-place with O(1) extra memory.
*
* 6/23/24
* Mark Robuck
*/
class Solution{
    /*
    * Remove duplicates in a list of numbers without moving the order of the elements.
    * @params nums, original list of integers
    * @return the number of elements in the list after duplicates are removed
    */
    public int removeDuplicates(int[] nums) {
        //check for empty list
        if (nums.length == 0){
            return 0;
        }
            
        //create pointers for modifying a value and checking a value
        int writePointer = 1;
        //track a counter for each value
        int count = 1;

        //traverse the list
        for (int readPointer = 1; readPointer < nums.length; readPointer++) {
            //if duplicate values add to the counter, otherwise reset counter
            if (nums[readPointer] == nums[readPointer - 1]) {
                count++;
            } else {
                count = 1;
            }
            //if 2 or less duplicates keep in the list
            if (count <= 2) {
                nums[writePointer] = nums[readPointer];
                writePointer++;
            }
        }   
        return writePointer;
    }
}
