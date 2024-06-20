/*
* Leetcode Challenge: Single Number
*
* Given a non-empty array of integers nums, every element appears twice except for one. 
* Find that single one.
* You must implement a solution with a linear runtime complexity 
* and use only constant extra space.
*
* 6/20/24
* Mark Robuck
*/
class Solution{
    /*
    * Find the unmatched intger in a list of pairs.
    * @params nums, list of integers to be searched
    * @return the only int in nums without a matching pair
    */
    public int singleNumber(int[] nums) {
        //XOR all the numbers together. Pairs of numbers will cancel each other out, 
        //leaving the single number that doesn't have a pair.
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
