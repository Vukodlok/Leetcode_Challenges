/*
* Leetcode Challenge: LRU Cache
*
* Design a data structure that follows the constraints of a 
* Least Recently Used (LRU) cache.
*
* Implement the LRUCache class:
* LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
* int get(int key) Return the value of the key if the key exists, 
* otherwise return -1.
* void put(int key, int value) Update the value of the key if the key exists. 
* Otherwise, add the key-value pair to the cache. If the number of keys 
* exceeds the capacity from this operation, evict the least recently used key.
*
* The functions get and put must each run in O(1) average time complexity.
*
* 8/13/24
* Mark Robuck
*/

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
import java.util.HashMap;

class LRUCache {

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /*
    * Implement a LRU cache.
    * @params capacity, size to initialize cache with
    */
    private final int capacity;
    private HashMap<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        //dummy nodes to avoid null checks
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    /*
    * Remove a node from the linked list
    * @params node, node to remove
    */
    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    /*
    * Add a node right after the head
    * @params node, node to add to the head
    */
    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
        
    /*
    * Get the key value if it exists
    * @params key, key to find the value of
    * @return key value if it exists, -1 otherwise
    */
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    /*
    * Add or modify key value, evict LRU key if over capacity
    * @params key, key to add to key-value pair
    * @params value, value to add to key-value pair
    */

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            //update existing node and move to head
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            addToHead(node);
        } else {
            if (cache.size() >= capacity) {
                //remove LRU node
                Node lruNode = tail.prev;
                remove(lruNode);
                cache.remove(lruNode.key);
            }
            //add new node
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
        }
    }
}
