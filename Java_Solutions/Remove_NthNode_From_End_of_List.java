/*
* Leetcode Challenge: Remove NthNode From End of List
*
* Given the head of a linked list, remove the nth node from 
* the end of the list and return its head.
*
* 8/7/24
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
    * Remove a node from a linked list.
    * @params head, original linked list head
    * @params n, node to be removed from the linked list
    * @return linked list with nth node removed
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //create two pointers
        ListNode first = dummy;
        ListNode second = dummy;

        //move first pointer n+1 steps
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        //move both pointers until first reaches end of linked list
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        //remove n-th node
        second.next = second.next.next;

        return dummy.next;
        
    }
}
