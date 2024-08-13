"""
Leetcode Challenge: LRU Cache

Design a data structure that follows the constraints of a 
Least Recently Used (LRU) cache.

Implement the LRUCache class:
LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, 
otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. 
Otherwise, add the key-value pair to the cache. If the number of keys 
exceeds the capacity from this operation, evict the least recently used key.

The functions get and put must each run in O(1) average time complexity.

8/13/24
Mark Robuck
"""

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)

class Node:
    def __init__(self, key: int, value: int):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

class LRUCache:
    """
    Implement a LRU cache.
    Args:
        capacity(int): size to initialize cache with
    """
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = {}  # Map from key to node
        self.head = Node(0, 0)  # Dummy head
        self.tail = Node(0, 0)  # Dummy tail
        self.head.next = self.tail
        self.tail.prev = self.head

    """
    Remove a node from the linked list
    Args:
        node(Node): node to remove
    """
    def _remove(self, node: Node):
        prev_node = node.prev
        next_node = node.next
        prev_node.next = next_node
        next_node.prev = prev_node

    """
    Add a node right after the head
    Args:
        node(Node): node to add to the head
    """
    def _add_to_head(self, node: Node):
        node.next = self.head.next
        node.prev = self.head
        self.head.next.prev = node
        self.head.next = node
        
    """
    Get the key value if it exists
    Args:  
        key(int): key to find the value of
    Returns:
        key value if it exists, -1 otherwise
    """
    def get(self, key: int) -> int:
        if key in self.cache:
            node = self.cache[key]
            self._remove(node)
            self._add_to_head(node)
            return node.value
        return -1
    """
    Add or modify key value, evict LRU key if over capacity
    Args:
        key(int): key to add to key-value pair
        value(int): value to add to key-value pair
    """
    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            node = self.cache[key]
            node.value = value
            self._remove(node)
            self._add_to_head(node)
        else:
            if len(self.cache) >= self.capacity:
                # Evict the LRU item
                lru_node = self.tail.prev
                self._remove(lru_node)
                del self.cache[lru_node.key]
            # Add new node
            new_node = Node(key, value)
            self.cache[key] = new_node
            self._add_to_head(new_node)
