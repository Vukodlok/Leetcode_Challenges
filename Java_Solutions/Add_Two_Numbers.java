/*
* Leetcode Challenge: Add Two Numbers
*
* You are given two non-empty linked lists representing two 
* non-negative integers. The digits are stored in reverse order, 
* and each of their nodes contains a single digit. Add the two numbers 
* and return the sum as a linked list.
*
* You may assume the two numbers do not contain any leading zero, 
* except the number 0 itself.
*
* 8/2/24
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

class Solution{
    /*
    * Add two numbers each represented as a linked list.
    * @params l1, first integer
    * @params l2, second integer
    * @return sum of l1 and l2 in reverse order
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        //access l1 and l2 in parallel
        while (l1 != null || l2 != null) {
            //get value of current node, or default to 0 if none
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            //sum each pair and update carry value
            int total = val1 + val2 + carry;
            carry = total / 10;
            int currentSum = total % 10;
            //add current_sum as new node
            current.next = new ListNode(currentSum);
            current = current.next;
            //move to next node
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        //add a new node for carry
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
     
    }
}
