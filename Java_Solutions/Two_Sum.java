/*
* Leetcode Challenge: Two Sum
*
* Given an array of integers nums and an integer target, 
* return indices of the two numbers such that they add up to target.
* You may assume that each input would have exactly one solution, 
* and you may not use the same element twice.
* You can return the answer in any order.
*
* 6/7/24
* Mark Robuck
*/

import java.util.HashMap;

public class Solution {
    /*
     * Find the indices of two numbers that add up to a target sum.
     * @param nums, list of possible numbers to add
     * @param target, sum we are trying to find a combination for
     * @return, return the two indices of the numbers with a sum of target
     * We can assume exactly one solution and a number in nums is only used once.
     */
    public int[] twoSum(int[] nums, int target) {
        //create a hashmap to store the value and its index
        HashMap<Integer, Integer> numbers = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            int value = nums[index];
            //check if the number in hashmap combined with existing numbers equals target
            if (numbers.containsKey(target - value)) {
                //return the indices of the two numbers that add up to the target
                return new int[] { numbers.get(target - value), index };
            }
            //if not add to the hashmap
            numbers.put(value, index);
        }
        // In case no solution is found, getting an error despite challenge desccription
        throw new IllegalArgumentException("No two sum solution");
    }
}
/* I used my python solution as help since I struggled with the python version of this. 
  A much simpiler but less efficient solution I could have used if made from scratch is the following.

  class Solution {
    public int[] twoSum(int[] nums, int target) {

        for(int i  = 1;i<nums.length;i++){
            for(int j = i; j<nums.length;j++){
                if(nums[j] + nums[j-i] == target){
                    return new int[] {j,j-i};
                }
            }
        }
        return null;
    }
}
*/
