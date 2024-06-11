"""
Leetcode Challenge: Linked List Cycle

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached 
again by continuously following the next pointer. Internally, pos is used to denote the 
index of the node that tail's next pointer is connected to. Note that pos is not passed 
as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

6/11/24
Mark Robuck
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    """
    Determine if a cycle exists in a linked list.
    Args:
        head(Optional[ListNode]): first node in the linked list
    Returns:
        bool: true if there is a cycle, false otherwise
    """
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        #create a set to store already visited nodes
        visited = set()
        #traverse the linked list
        current = head
        while current:
            #if current node is in visited there is a cycle
            if current in visited:
                return True
            #otherwise add current node to visited
            visited.add(current)
            current = current.next
        #if the last node is reached without finding a match in visited
        return False

"""
While researching I found refernece to a clever solution called Floyd's Tortoise and Hare Algorithm that uses a faster
and slower pointer both traversing the linked list.  If the faster pointer ever catches up to the slower pointer there is a cycle.

#Floyd's Tortoise and Hare Algorithm 
slow,fast = head,head

while fast and fast.next: #while not null
    slow = slow.next
    fast = fast.next.next
    if slow == fast:
        return True #there is a cycle
        
return False  #There is no cycle
"""
