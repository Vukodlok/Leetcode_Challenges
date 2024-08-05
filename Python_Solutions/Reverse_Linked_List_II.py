"""
Leetcode Challenge: Reverse Linked List II

Given the head of a singly linked list and two integers 
left and right where left <= right, reverse the nodes of the 
list from position left to position right, and return the reversed list.

8/5/24
Mark Robuck
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    """
    Reverse a portion of a linked list.
    Args:
        head(ListNode): original linked list head
        left(int): node for start of interval to reverse
        right(int): node for end of interval to reverse
    Returns:
        ListNode: linked list with reversed interval
    """
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        #base case, null head or invalid range
        if not head or left == right:
            return head

        dummy = ListNode(0)
        dummy.next = head
        prev = dummy
        for _ in range(left - 1):
            prev = prev.next

        #reverse the sublist from left to right
        current = prev.next
        prev_sublist = None
        for _ in range(right - left + 1):
            #temp store next node
            next_node = current.next
            #reverse current node pointer
            current.next = prev_sublist
            #move prev sublist to current node
            prev_sublist = current
            current = next_node

        #connect reversed sublist to previous list
        prev.next.next = current
        prev.next = prev_sublist

        return dummy.next
