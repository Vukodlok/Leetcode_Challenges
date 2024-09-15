"""
Leetcode Challenge: Sort List

Given the head of a linked list, return the list after sorting 
it in ascending order.

9/15/24
Mark Robuck
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    """
    Sort a linked list in ascending order.
    Args: 
        head(ListNode): original list head
    Return:
        the sorted linked list
    """
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        #base case: empty list, only one node, or already sorted
        if not head or not head.next:
            return head

        #split the list in half using two pointers
        slow, fast = head, head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        #cut the list into two halves
        mid = slow.next
        slow.next = None

        #sort each half recursively
        left = self.sortList(head)
        right = self.sortList(mid)

        #merge the two sorted halves
        return self.merge(left, right)

    #merge sort function
    def merge(self, left, right):
        dummy = ListNode()
        current = dummy

        while left and right:
            if left.val < right.val:
                current.next = left
                left = left.next
            else:
                current.next = right
                right = right.next
            current = current.next

        #attach remaining nodes
        if left:
            current.next = left
        if right:
            current.next = right

        return dummy.next
