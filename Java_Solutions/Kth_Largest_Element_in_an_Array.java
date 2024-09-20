/*
* Leetcode Challenge: Kth Largest Element in an Array
*
* Given an integer array nums and an integer k, 
* return the kth largest element in the array.
* Note that it is the kth largest element in the sorted order, 
* not the kth distinct element.
* Can you solve it without sorting?
*
* 9/20/24
* Mark Robuck
*/
import java.util.PriorityQueue;

class Solution {
    /*
    * Find the kth largest element in an unsorted list.
    * @params nums, list of unsorted integers
    * @params k, index of the integer to be found if sorted
    * @return integer value of the kth largest element
    */
    public int findKthLargest(int[] nums, int k) {
        //use a min-heap to efficiently find the kth largest element
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                //remove smallest element to maintain k elements
                minHeap.poll(); 
            }
        }
        //the root of the heap is the kth largest element
        return minHeap.peek();
    }
}
