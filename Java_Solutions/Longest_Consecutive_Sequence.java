/*
* Leetcode Challenge: Longest Consecutive Sequence
*
* Given an unsorted array of integers nums, 
* return the length of the longest consecutive elements sequence.
* You must write an algorithm that runs in O(n) time.
*
* 7/25/24
* Mark Robuck
*/
import java.util.HashSet;
import java.util.Set;

class Solution{
    /*
    * Find the longest sequence of consecutive numbers in a list.
    * @params nums, original given list
    * @return length of longest consecutive sequence
    */
    public int longestConsecutive(int[] nums) {
        //empty list
        if (nums.length == 0) {
            return 0;
        }

        //create a set from the list
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        //iterate through the list
        for (int num : numSet) {
            //check for start of a sequence
            if (!numSet.contains(num - 1)) {
                //update variables
                int currentNum = num;
                int currentLength = 1;

                //check for consecutive sequence
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentLength += 1;
                }
                
                //find the longest sequence
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
}
