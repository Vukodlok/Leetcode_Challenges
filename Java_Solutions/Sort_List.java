/*
* Leetcode Challenge: Sort List
*
* Given the head of a linked list, return the list after sorting 
* it in ascending order.
*
* 9/15/24
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
    * Sort a linked list in ascending order.
    * @params head, original list head
    * @return the sorted linked list
    */
    public ListNode sortList(ListNode head) {
        //base case: empty list, only one node, or already sorted
        if (head == null || head.next == null) {
            return head;
        }

        //split the list in half using two pointers
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //cut the list into two halves
        ListNode mid = slow.next;
        slow.next = null;

        //sort each half recursively
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        //merge the two sorted halves
        return merge(left, right);
    }

    //merge sort function
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        //attach remaining nodes
        if (left != null) {
            current.next = left;
        }
        if (right != null) {
            current.next = right;
        }

        return dummy.next;
    }
}
