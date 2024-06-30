"""
Leetcode Challenge: Insert Delete GetRandom O(1)

Implement the RandomizedSet class:
RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. 
Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. 
Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements 
(it's guaranteed that at least one element exists when this method is called). 
Each element must have the same probability of being returned.
You must implement the functions of the class such that 
each function works in average O(1) time complexity.

6/30/24
Mark Robuck
"""
# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
import random

class RandomizedSet:
    """
    Implement the RandomizedSet class
    """
    def __init__(self):
        self.dict = {}
        self.list = []
    """
    Insert an item into a set if not present.
    Args:
        val(int): integer to be inserted into the set
    Returns:
        bool: true if item was inserted, false otherwise
    """
    def insert(self, val: int) -> bool:
        if val in self.dict:
            return False
        self.dict[val] = len(self.list)
        self.list.append(val)
        return True
    """
    Remove an item from a set if present.
    Args:
        val(int): integer to be removed from the set
    Returns:
        bool: true if item was removed, false otherwise
    """
    def remove(self, val: int) -> bool:
        if val not in self.dict:
            return False
        #move the element we want deleted to the end
        last = self.list[-1]
        i = self.dict[val]
        self.list[i] = last
        self.dict[last] = i
        #remove the last element
        self.list.pop()
        del self.dict[val]
        return True
    """
    Selected a value from the set at random.
    Returns:
        int: value of the element randomly selected
    """
    def getRandom(self) -> int:
        return random.choice(self.list)
