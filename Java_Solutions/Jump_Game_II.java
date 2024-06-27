/*
* Leetcode Challenge: Jump Game II
*
* You are given a 0-indexed array of integers nums of length n. 
* You are initially positioned at nums[0].
* Each element nums[i] represents the maximum length of a forward jump 
* from index i. In other words, if you are at nums[i], 
* you can jump to any nums[i + j] where:
* 0 <= j <= nums[i] and
* i + j < n
* Return the minimum number of jumps to reach nums[n - 1]. 
* The test cases are generated such that you can reach nums[n - 1].
*
* 6/27/24
* Mark Robuck
*/

class Solution{
    /*
    * Find minimum number of jumps to reach the end of an array. 
    * Each element represents the max jump distance from that index.
    * @params nums, given list of max jump lengths
    * @return min number of jumps to reach the end of the list
    */
    public int jump(int[] nums) {        
        int n = nums.length;
        int jumps = 0;
        int current_end = 0;
        int farthest = 0;

        //only one element in list
        if (n < 2){
            return 0;
        }
        
        for (int i = 0; i < nums.length; i++){
            //track farthest possible jump
            farthest = Math.max(farthest, i + nums[i]);
            //if at the farthest jump for the index, make a jump
            if (i == current_end){
                jumps++;
                current_end = farthest;
                //break the loop when we reach the end of the list
                if (current_end >= n-1){
                    break;
                }
            }
        }
        return jumps;   
    }
}
