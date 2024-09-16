/*
* Leetcode Challenge: Merge k Sorted Lists
*
* You are given an array of k linked-lists lists, 
* each linked-list is sorted in ascending order.
*
* Merge all the linked-lists into one sorted linked-list and return it.
*
* 9/16/24
* Mark Robuck
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.PriorityQueue;

class Solution {
    /*
    * Merge a list of sorted linked-lists into a merged list.
    * @params lists, list of sorted linked-lists, ascending order
    * @return sorted linked-list merging lists
    */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        //insert the head node of each list into the min heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        //grab smallest element from the heap, add to the merged list
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;
            
            //if extracted node has a next, push next node onto the heap
            if (node.next != null) {
                minHeap.add(node.next);
            }
        }

        return dummy.next;
    }
}
