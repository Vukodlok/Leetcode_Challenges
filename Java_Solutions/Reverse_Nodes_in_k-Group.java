/*
* Leetcode Challenge: Reverse Nodes in k-Group
*
* Given the head of a linked list, reverse the nodes of the list k at a time, 
* and return the modified list. k is a positive integer and is less than 
* or equal to the length of the linked list. If the number of nodes is not 
* a multiple of k then left-out nodes, in the end, should remain as it is.
*
* You may not alter the values in the list's nodes, 
* only nodes themselves may be changed.
*
* 8/6/24
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
    /**
     * Reverse multiple portions of a linked list.
     * @param head head of the original linked list
     * @param k length of sublists to reverse
     * @return linked list with reverse portions of k length
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        //list of zero or one length
        if (head == null || k == 1) {
            return head;
        }

        //dummy node to point to head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        //count length of the linked list
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count++;
        }

        //reverse nodes in k groups
        while (count >= k) {
            curr = prev.next;
            ListNode nextNode = curr.next;
            for (int i = 1; i < k; i++) {
                curr.next = nextNode.next;
                nextNode.next = prev.next;
                prev.next = nextNode;
                nextNode = curr.next;
            }
            prev = curr;
            count -= k;
        }

        return dummy.next;
    }
}
