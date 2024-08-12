/*
* Leetcode Challenge: Partition List
*
* Given the head of a linked list and a value x, 
* partition it such that all nodes less than x come before nodes 
* greater than or equal to x.
*
*You should preserve the original relative order of the nodes 
*in each of the two partitions.
*
* 8/12/24
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
class Solution {
    /*
    * Partition a linked list based on less than and greater than a value.
    * @params head, original linked list
    * @params x, value to partition linked list based on
    * @return partitioned linked list
    */
    public ListNode partition(ListNode head, int x) {
        //create dummy nodes for each partition
        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        //pointers for current end of each partition
        ListNode less = lessDummy;
        ListNode greater = greaterDummy;

        //iterate through linked list
        ListNode current = head;
        while (current != null) {
            //append to nodes less than x
            if (current.val < x) {
                less.next = current;
                less = less.next;
            } else {
            //append to nodes greater than x
                greater.next = current;
                greater = greater.next;
            }
            current = current.next;
        }

        //set end of greater partition and combine partitions
        greater.next = null;
        less.next = greaterDummy.next;

        return lessDummy.next;
        
    }
}
