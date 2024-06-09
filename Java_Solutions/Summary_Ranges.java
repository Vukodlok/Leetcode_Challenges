/*
* Leetcode Challenge: Summary Ranges
*
* You are given a sorted unique integer array nums.
*
* A range [a,b] is the set of all integers from a to b (inclusive).
*
* Return the smallest sorted list of ranges that cover all the numbers 
* in the array exactly. That is, each element of nums is covered by exactly one 
* of the ranges, and there is no integer x such that 
* x is in one of the ranges but not in nums.
*
* Each range [a,b] in the list should be output as:
*
* "a->b" if a != b
* "a" if a == b
*
* 6/9/24
* Mark Robuck
*/
import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
    * Return a formatted string representing a range of numbers in a list.
    * @params nums, list of integers to be formatted
    * @return, formatted list of nums as strings
    */
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums.length == 0) {
            return result;
        }

        int start = nums[0];

        for (int i = 1; i < nums.length; i++) {
            //check for nonconsecutive values, and close the range
            if (nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + nums[i - 1]);
                }
                start = nums[i];
            }
        }

        //add the final range to result
        if (start == nums[nums.length - 1]) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + nums[nums.length - 1]);
        }
        
        return result;
    }
}
