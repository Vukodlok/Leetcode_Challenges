/* 
* Leetcode challenge: Merge Sorted Array
*
* You are given two integer arrays nums1 and nums2, sorted in ascending order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
* Merge nums1 and nums2 into a single array sorted in ascending order.
* The final sorted array should not be returned by the function, but instead be stored inside the array nums1. 
* To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, 
* and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
*
* Created: 5/13/24
* Author: Mark Robuck
*/
class Solution {
    /*
    * Merge two sorted arrays back into the first array, in ascending order
    @param int[] nums1, sorted array of m elements followed by n elements set to zero
    @param int[] nums2, sorted array of n elements
    @param int m, number of sorted elements at the front portion of nums1
    @param int n, number of sorted elements in nums2, and the number of empty 0 elements at the back portion of nums1
    */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //set pointers
        int i = m - 1;
        int j = n - 1;
        int spot = n + m - 1;
        //loop through nums1
        while (j >= 0) {
            //if nums1 value is larger add to end of list and move i back one
            if (i >= 0 && nums1[i] > nums2[j]){
                nums1[spot] = nums1[i];
                i --;
            }
            //if nums2 value is larger add to end of list and move j back one
            else{
                nums1[spot] = nums2[j];
                j --;
            }
            spot--;
        }
    }
}
/*In my Python solution, which I coded first, I discovered the check at the end
are redundant and I left them off the Java solution. */
