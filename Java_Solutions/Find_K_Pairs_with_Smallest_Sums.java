/*
* Leetcode Challenge: Find K Pairs with Smallest Sums
*
* You are given two integer arrays nums1 and nums2 sorted in 
* non-decreasing order and an integer k.
*
* Define a pair (u, v) which consists of one element from the first 
* array and one element from the second array.
*
* Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
*
* 9/21/24
* Mark Robuck
*/
import java.util.*;

class Solution {
    /*
    * Find pairs of values from two lists in order of smallest sum.
    * @params nums1, list of sorted integers
    * @params nums2, list of sorted integers
    * @params k, number of pairs to return
    * @return pairs of integers from nums1, nums2 in order of smallest sum
    */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //min-heap for maintaining the smallest sum pairs
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        List<List<Integer>> result = new ArrayList<>();
        
        //edge case
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }
        
        //add the first k pairs from nums1[0] and all of nums2
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});
        }
        
        //extract k smallest pairs
        while (k > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            result.add(Arrays.asList(current[0], current[1]));
            k--;
            
            //if possible, push the next pair (nums1[i], nums2[j+1]) into the heap
            if (current[2] + 1 < nums2.length) {
                minHeap.offer(new int[]{current[0], nums2[current[2] + 1], current[2] + 1});
            }
        }
        
        return result;
    }
}
