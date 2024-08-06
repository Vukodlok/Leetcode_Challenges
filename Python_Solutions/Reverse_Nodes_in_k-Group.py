"""
Leetcode Challenge: Reverse Nodes in k-Group

Given the head of a linked list, reverse the nodes of the list k at a time, 
and return the modified list. k is a positive integer and is less than 
or equal to the length of the linked list. If the number of nodes is not 
a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, 
only nodes themselves may be changed.

8/6/24
Mark Robuck
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    """
    Reverse multiple portions of a linked list.
    Args:
        head(ListNode): head of the original linked list
        k(int): length of sublists to reverse
    Returns:
        ListNode: linked list with reverse portions of k length
    """
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        #list of zero or one length
        if head is None or k == 1:
            return head

        #dummy node to point to head
        dummy = ListNode(0)
        dummy.next = head

        prev = dummy
        curr = head

        #count length of the linked list
        count = 0
        while curr:
            curr = curr.next
            count += 1

        #reverse nodes in k groups
        while count >= k:
            curr = prev.next
            next_node = curr.next
            for _ in range(1, k):
                curr.next = next_node.next
                next_node.next = prev.next
                prev.next = next_node
                next_node = curr.next
            prev = curr
            count -= k
        
        return dummy.next
