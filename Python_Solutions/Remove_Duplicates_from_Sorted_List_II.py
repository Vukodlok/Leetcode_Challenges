"""
Leetcode Challenge: Remove Duplicates from Sorted List II

Given the head of a sorted linked list, delete all nodes that 
have duplicate numbers, leaving only distinct numbers from the 
original list. Return the linked list sorted as well.

8/8/24
Mark Robuck
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    """
    Remove all numbers that have duplicates from a linked list.
    Args: 
        head(ListNode): original linked list
    Returns:
        ListNode: linked list with duplicates removed
    """
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0)
        dummy.next = head

        #create pointers
        prev = dummy
        current = head

        #check for duplicates
        while current:
            if current.next and current.val == current.next.val:
                #skip nodes with same values
                while current.next and current.val == current.next.val:
                    current = current.next 
                #connect prev to node after last duplicate
                prev.next = current.next
            else:
                #move prev if current is not a duplicate
                prev = current

            current = current.next
        
        return dummy.next
        
