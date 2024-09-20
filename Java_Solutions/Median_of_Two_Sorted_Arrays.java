/*
* Leetcode Challenge: Median of Two Sorted Arrays
*
* Given two sorted arrays nums1 and nums2 of size m and n respectively, 
* return the median of the two sorted arrays.
*
* The overall run time complexity should be O(log (m+n)).
*
* 9/20/24
* Mark Robuck
*/

class Solution {
    /*
    * Merge two arrays then find the median element.
    * @params nums1, list of integers
    * @params nums2, list of integers
    * @return median of nums1 and nums2 merged together
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;
        
        //binary search using partitions of the lists ensuring left elements are smaller or equal to the right elements
        while (low <= high) {
            int partition1 = (low + high) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;

            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];

            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((m + n) % 2 == 0) {
                    return ((double)Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}
