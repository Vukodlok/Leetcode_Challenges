/*
* Leetcode Challenge: Remove Duplicates from Sorted List II
*
* Given the head of a sorted linked list, delete all nodes that 
* have duplicate numbers, leaving only distinct numbers from the 
* original list. Return the linked list sorted as well.
* 
* 8/8/24
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
    * Remove all numbers that have duplicates from a linked list.
    * @params head, original linked list
    * @return linked list with duplicates removed
    */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //create pointers
        ListNode prev = dummy;
        ListNode current = head;

        //check for duplicates
        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                //skip nodes with same values
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                //connect prev to node after last duplicate
                prev.next = current.next;
            } else {
                //move prev if current is not a duplicate
                prev = current;
            }
            current = current.next;
        }
        return dummy.next;       
    }
}
