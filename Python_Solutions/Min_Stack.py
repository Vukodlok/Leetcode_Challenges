"""
Leetcode Challenge: Min Stack

Design a stack that supports push, pop, top, and retrieving 
the minimum element in constant time.
Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

7/30/24
Mark Robuck
"""

class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []
        
    """
    pushes the element val onto the stack.
    Args:
        val(int): integer to push to the stack
    """
    def push(self, val: int) -> None:
        self.stack.append(val)
        #if min push to min_stack
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)
        
    """
    removes the element on the top of the stack.
    """
    def pop(self) -> None:
        if self.stack:
            popped = self.stack.pop()
        #if min pop from min_stack
        if self.min_stack and popped == self.min_stack[-1]:
                self.min_stack.pop()
    """
    gets the top element of the stack.
    Returns:
        int: integer on the top of the stack
    """
    def top(self) -> int:
        if self.stack:
            return self.stack[-1]
    """
    retrieves the minimum element in the stack.
    Returns:
        int: minimum integer in the stack
    """
    def getMin(self) -> int:
        if self.min_stack:
            return self.min_stack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
