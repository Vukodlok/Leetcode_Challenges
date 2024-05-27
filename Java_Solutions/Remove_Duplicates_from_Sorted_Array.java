/*
* Leetcode Challenge: Remove Duplicates from Sorted Array
* 
* Given an integer array nums sorted in non-decreasing order, 
* remove the duplicates in-place such that each unique element appears only once. 
* The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
* Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
* Change the array nums such that the first k elements of nums contain the unique elements in the order they were
* present in nums initially. The remaining elements of nums are not important as well as the size of nums.
* Return k.
*
* 5/15/24
* Mark Robuck
*/
class Solution {
    /*
    * Remove all duplicate values from the sorted array
    * @params nums, list of integers in ascending order
    * @return integer length of list after duplicates are removed
    */
    public int removeDuplicates(int[] nums) {
        //create two pointers for start and end of the array
        int left = 0;
        int right = nums.length - 1;
        //check for empty or single value arrays
        if (nums.length <= 1) {
            return nums.length;
        }
        //loop through initial list
        while (left <= right) {
            //continue to check for duplicates
            while (left < right && nums[left] == nums[left+1]) {
                //shift left duplicate to the end of the list and everything else one left
                int temp = nums[left];
                for (int i = left; i < right; i++) {
                    nums[i] = nums[i+1];
                }
                nums[right] = temp;
                right--;
            }
            left++;
        }
        return left;
    }
}
/*This solution was incredibilty inefficient compared to others. A better solution was the following:
        int i=1;
        for(int j=1; j<nums.length; j++){
            if(nums[j] != nums[j-1]){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
*/
