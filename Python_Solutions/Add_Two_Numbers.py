"""
Leetcode Challenge: Add Two Numbers

You are given two non-empty linked lists representing two 
non-negative integers. The digits are stored in reverse order, 
and each of their nodes contains a single digit. Add the two numbers 
and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, 
except the number 0 itself.

8/2/24
Mark Robuck
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    """
    Add two numbers each represented as a linked list.
    Args: 
        l1(ListNode): first integer
        l2(ListNode): second integer
    Returns:
        ListNode: sum of l1 and l2 in reverse order
    """
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy_head = ListNode(0)
        current = dummy_head
        carry = 0

        #access l1 and l2 in parallel
        while l1 or l2:
            #get value of current node, or default to 0 if none
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0
            #sum each pair and update carry value
            total = val1 +val2 + carry
            carry = total // 10
            current_sum = total % 10
            #add current_sum as new node
            current.next = ListNode(current_sum)
            current = current.next
            #move to next node
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next

        #add a new node for carry
        if carry > 0:
            current.next = ListNode(carry)

        return dummy_head.next
