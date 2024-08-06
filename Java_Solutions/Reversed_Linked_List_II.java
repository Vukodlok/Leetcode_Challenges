/*
* Leetcode Challenge: Reverse Linked List II
*
* Given the head of a singly linked list and two integers 
* left and right where left <= right, reverse the nodes of the 
* list from position left to position right, and return the reversed list.
*
* 8/5/24
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
    /*
    * Reverse a portion of a linked list.
    * @params head, original linked list head
    * @params left, node for start of interval to reverse
    * @params right, node for end of interval to reverse
    * @returns linked list with reversed interval
    */
        //base case, null head or invalid range
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        //reverse the sublist from left to right
        ListNode current = prev.next;
        ListNode next = null;
        ListNode prevSublist = null;
        
        for (int i = 0; i < right - left + 1; i++) {
            //temp store next node
            next = current.next;
            //reverse current node pointer
            current.next = prevSublist;
            //move prev sublist to current node
            prevSublist = current; // Move prevSublist to current node
            current = next;
        }

        //connect reversed sublist to previous list
        prev.next.next = current;
        prev.next = prevSublist;

        return dummy.next;   
    }
}
