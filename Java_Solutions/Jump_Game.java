/*
* Leetcode Challenge: Jump Game
*
* You are given an integer array nums. You are initially positioned 
* at the array's first index, and each element in the array represents 
* your maximum jump length at that position.
* Return true if you can reach the last index, or false otherwise.
*
* 6/26/24
* Mark Robuck
*/
class Solution{
    /*
    * Determine if the entire array can be traversed given the game rules.
    * @params nums, list of jump lengths as integers
    * @return true if the end of the list can be reached, false otherwise
    */
    public boolean canJump(int[] nums) {
        int max_reach = 0;
        for (int i = 0; i < nums.length; i++) {
            //current position is beyond max_reach
            if (i > max_reach){
                return false;
            }
            //update max_reach
            max_reach = Math.max(max_reach, i + nums[i]);
            //max_reach is at or beyond last index
            if (max_reach >= nums.length - 1){
                return true;
            }       
        }
        return false;
    }
}
