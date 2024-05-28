"""
Leetcode Challenge: Merge Two Sorted Lists

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by 
splicing together the nodes of the first two lists.
Return the head of the merged linked list.

5/28/24
Mark Robuck
"""

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    """
    Merge two sorted lists into one sorted list.
    Args:
        list1(Optional[ListNode]): first list to merge
        list2(Optional[ListNode]): second list to merge
    Returns:
        Optional[ListNode]: merged final list
    """
    def mergeTwoLists(self, list1, list2):
        #make a starting pointer
        start = ListNode()
        #make a ListNode for the merged lists
        merged = start
        #merge the lists into merged in ascending order
        while list1 and list2:
            if list1.val < list2.val:
                merged.next = list1
                list1 = list1.next
            else:
                merged.next = list2
                list2 = list2.next
            merged = merged.next
        if list1:
            merged.next = list1
        else:
            merged.next = list2
        return start.next
