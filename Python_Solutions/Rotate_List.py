"""
Leetcode Challenge: Rotate List

Given the head of a linked list, rotate the list to the right by k places.

8/11/24
Mark Robuck
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    """
    Rotate a linked list a certain number of nodes.
    Args:
        head(ListNode): original linked list
        k(int): number of nodes to rotate head
    Returns:
        Listnode: rotated linked list
    """
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        #empty list
        if not head:
            return head

        #find length of list
        length = 1
        #find last node
        current = head
        while current.next:
            current = current.next
            length += 1
        
        #create circular list
        current.next = head

        #find new head
        k = k % length
        steps_to_new_head = length - k

        #find new head and tail
        new_tail = head
        for _ in range(steps_to_new_head - 1):
            new_tail = new_tail.next

        new_head = new_tail.next
        new_tail.next = None

        return new_head
