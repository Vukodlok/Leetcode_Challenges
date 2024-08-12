"""
Leetcode Challenge: Partition List

Given the head of a linked list and a value x, 
partition it such that all nodes less than x come before nodes 
greater than or equal to x.

You should preserve the original relative order of the nodes 
in each of the two partitions.

8/12/24
Mark Robuck
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    """
    Partition a linked list based on less than and greater than a value.
    Args:
        head(ListNode): original linked list
        x(int): value to partition linked list based on
    Returns:
        ListNode: partitioned linked list
    """
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        #create dummy nodes for each partition
        less_dummy = ListNode(0)
        greater_dummy = ListNode(0)

        #pointers for current end of each partition
        less = less_dummy
        greater = greater_dummy

        #iterate through linked list
        current = head
        while current:
            #append to nodes less than x
            if current.val < x:
                less.next = current
                less = less.next
            #append to nodes greater than x
            else:
                greater.next = current
                greater = greater.next
            current = current.next

        #set end of greater partition and combine partitions
        greater.next = None
        less.next = greater_dummy.next

        return less_dummy.next
