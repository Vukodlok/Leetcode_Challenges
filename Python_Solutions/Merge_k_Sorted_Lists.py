"""
Leetcode Challenge: Merge k Sorted Lists

You are given an array of k linked-lists lists, 
each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

9/16/24
Mark Robuck
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq

class Solution:
    """
    Merge a list of sorted linked-lists into a merged list.
    Args:
        lists(ListNode): list of sorted linked-lists, ascending order
    Returns:
        ListNode: sorted linked-list merging lists
    """
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        min_heap = []

        #insert the head node of each list into the min heap
        for i, l in enumerate(lists):
            if l:
                heapq.heappush(min_heap, (l.val, i, l))

        dummy = ListNode(0)
        current = dummy
        
        #grab smallest element from the heap, add to the merged list
        while min_heap:
            val, i, node = heapq.heappop(min_heap)
            current.next = ListNode(val)
            current = current.next
            
            #if extracted node has a next, push next node onto the heap
            if node.next:
                heapq.heappush(min_heap, (node.next.val, i, node.next))
        
        return dummy.next
