/*
* Leetcode Challenge: Product of Array Except Self
*
* Given an integer array nums, return an array answer such that answer[i] 
* is equal to the product of all the elements of nums except nums[i].
* The product of any prefix or suffix of nums is guaranteed to 
* fit in a 32-bit integer.
* You must write an algorithm that runs in O(n) time 
* and without using the division operation.
*
* 7/1/24
* Mark Robuck
*/
class Solution{
    /*
    * Find the product of all elements in a list except at the current index.
    * @params nums, original list if integers
    * @return product of all numbers except at the same index
    */
    public int[] productExceptSelf(int[] nums) {
        //create an intial list filled with ones
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
        }
        //create pointers
        int left = 1;
        int right = 1;
        //pass through the list left to right
        for (int i = 0; i < nums.length; i++){
            //grab the previous value
            result[i] *= left;
            //set each new left side value
            left *= nums[i];
        }

        //pass through the list right to left
        for (int i = nums.length - 1; i >= 0; i--){
            //grab the previous value
            result[i] *= right;
            //set each new right side value, combined with the left side value
            right *= nums[i];
        }
        return result;
    }
}
