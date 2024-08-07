"""
Leetcode Challenge: Remove NthNode From End of List

Given the head of a linked list, remove the nth node from 
the end of the list and return its head.

8/7/24
Mark Robuck
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    """Remove a node from a linked list.
    Args:
        head(ListNode): original linked list head
        n(int): node to be removed from the linked list
    Returns:
        linked list with nth node removed
    """
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(0)
        dummy.next = head

        #create two pointers
        first = dummy
        second = dummy

        #move first pointer n+1 steps
        for _ in range(n+1):
            first = first.next

        #move both pointers until first reaches end of linked list
        while first is not None:
            first = first.next
            second = second.next

        #remove n-th node
        second.next = second.next.next

        return dummy.next
