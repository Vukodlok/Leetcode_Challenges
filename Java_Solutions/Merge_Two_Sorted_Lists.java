/*
* Leetcode Challenge: Merge Two Sorted Lists
*
* You are given the heads of two sorted linked lists list1 and list2.
*
* Merge the two lists into one sorted list. The list should be made by 
* splicing together the nodes of the first two lists.
* Return the head of the merged linked list.
*
* 5/28/24
* Mark Robuck
*
***
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
    * Merge two sorted lists into one sorted list.
    * @params list1, first ListNode to merge
    * @params list2, second Listnode to merge
    * @return merged final ListNode
    */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //make a starting pointer
        ListNode start = new ListNode();
        //make a ListNode for the merged lists
        ListNode merged = start;
        //merge the lists into merged in ascending order
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                merged.next = list1;
                list1 = list1.next;
            }
            else {
                merged.next = list2;
                list2 = list2.next;
            }
            merged = merged.next;
        }
        if (list1 != null){
            merged.next = list1;
        }
        else {
            merged.next = list2;
        }
        return start.next;
    }
}
