"""
Leetcode Challenge: Implement Trie (Prefix Tree)

A trie (pronounced as "try") or prefix tree is a tree data structure 
used to efficiently store and retrieve keys in a dataset of strings. 
There are various applications of this data structure, such as 
autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in 
the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a 
previously inserted string word that has the prefix prefix, and 
false otherwise.

9/6/24
Mark Robuck
"""

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)

class TrieNode:
    def __init__(self):
        #each node will have a dictionary to store children and a boolean flag to mark the end of a word
        self.children = {}
        self.is_end_of_word = False


class Trie:

    def __init__(self):
        self.root = TrieNode()
    """
    insert a value into the trie if not present
    Args:
        word(str): string to be inserted
    """
    def insert(self, word: str) -> None:
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
        node.is_end_of_word = True
    """
    search for a string value in the existing Trie
    Args:
        word(str): string to be searched for
    Returns:
        bool: true if the string exists in trie, flase otherwise
    """
    def search(self, word: str) -> bool:
        node = self.root
        for char in word:
            if char not in node.children:
                return False
            node = node.children[char]
        return node.is_end_of_word
    """
    search for a string in trie that begins with the given substring
    Args:
        prefix(str): substring to be searched for
    Returns:
        bool: true if any string in trie starts with prefix, false otherwise
    """
    def startsWith(self, prefix: str) -> bool:
        node = self.root
        for char in prefix:
            if char not in node.children:
                return False
            node = node.children[char]
        return True
