/*
* Leetcode Challenge: Search Insert Position
*
* Given a sorted array of distinct integers and a target value, 
* return the index if the target is found. 
* If not, return the index where it would be if it were inserted in order.
* You must write an algorithm with O(log n) runtime complexity.
*
* 6/19/24
* Mark Robuck
*/
class Solution {
    /*
    * Binary search for a value and return the index where it is or should be if missing.
    * @params nums, list of integers to search
    * @return index of searched for value if in list, otherwise index value should be at
    */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            //set the current middle of the list
            int mid = left + (right - left) / 2;
            //is target at mid
            if (nums[mid] == target) {
                return mid;
            }
            //is target greater
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            //is target less
            else {
                right = mid - 1;
            }
        }
        //return insertion point if value not in list
        return left;
    }
}
