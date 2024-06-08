/*
* Leetcode Challenge: Contains Duplicate II
*
* Given an integer array nums and an integer k, 
* return true if there are two distinct indices i and j in the array such that 
* nums[i] == nums[j] and abs(i - j) <= k.
*
* 6/8/24
* Mark Robuck
*/
import java.util.HashMap;

class Solution {
    /*
    * Check if a list contains two elements that are equals and k or less indices apart.
    * @params nums, list of integer numbers to check
    * @params k, max index distance the two matching values can be apart in the list
    * @return, true if list contains a matching value that is also k or less indices apart
    */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //create a hashmap of values and indices
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        //iterate through list
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // Check if the number has been seen before and the distance condition is met
            if (indexMap.containsKey(num) && i - indexMap.get(num) <= k) {
                return true;
            }
            // Update the last seen index of the number
            indexMap.put(num, i);
        }
        return false;
    }
}
