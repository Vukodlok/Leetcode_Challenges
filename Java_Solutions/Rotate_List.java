/*
* Leetcode Challenge: Rotate List
*
* Given the head of a linked list, rotate the list to the right by k places.
*
* 8/11/24
* Mark Robuck
*/

class Solution{
    /*
    * Rotate a linked list a certain number of nodes.
    * @params head, original linked list
    * @params k, number of nodes to rotate head
    * @return rotated linked list
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
    public ListNode rotateRight(ListNode head, int k) {
        //empty list
        if (head == null) {
            return head;
        }

        //find length of list
        int length = 1;
        //find last node
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        
        //create circular list
        current.next = head;

        //find new head
        k = k % length;
        int stepsToNewHead = length - k;

        //find new head and tail
        ListNode newTail = head;
        for (int i = 0; i < stepsToNewHead - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
        
    }
}
