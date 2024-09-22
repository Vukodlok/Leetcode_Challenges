/*
* Leetcode Challenge: Single Number II
*
* Given an integer array nums where every element appears three times
* except for one, which appears exactly once. Find the single element
* and return it.
*
* You must implement a solution with a linear runtime complexity
* and use only constant extra space.
*
* 9/22/24
* Mark Robuck
*/

class Solution {
    /*
    * Find the only number in a list that only appears once.
    * @params nums, list of integers, only one doesn't repeat
    * @return value of the integer in nums that does not repeat
    */
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        
        for (int num : nums) {
            //ones holds XOR of all elements that have appeared once
            ones = (ones ^ num) & ~twos;
            //twos holds XOR of all elements that have appeared twice
            twos = (twos ^ num) & ~ones;
        }
        return ones;  
    }
}
