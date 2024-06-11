/*
* Leetcode Challenge: Linked List Cycle
* 
* Given head, the head of a linked list, determine if the linked list has a cycle in it.
*
* There is a cycle in a linked list if there is some node in the list that can be reached 
* again by continuously following the next pointer. Internally, pos is used to denote the 
* index of the node that tail's next pointer is connected to. Note that pos is not passed 
* as a parameter.
*
* Return true if there is a cycle in the linked list. Otherwise, return false.
*
* 6/11/24
* Mark Robuck
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

class Solution{
    /*
    * Determine if a cycle exists in a linked list.
    * @params head, first node in the linked list
    * @return, true if there is a cycle, false otherwise
    */
    public boolean hasCycle(ListNode head) {
        //check for empty linkedList
        if (head == null || head.next == null) {
            return false;
        }

        //initialize two pointers, slow and fast
        ListNode slow = head;
        ListNode fast = head;

        //traverse the list with two pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            //if slow pointer and fast pointer meet, there is a cycle
            if (slow == fast) {
                return true;
            }
        }

        //if we reach the end of the list, there is no cycle
        return false;
    }
}
