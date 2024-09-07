"""
Leetcode Challenge: Design Add and Search Words Data Structure

Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.

9/7/24
Mark Robuck
"""

# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)

class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end_of_word = False

class WordDictionary:

    #create a data structure of words
    def __init__(self):
        self.root = TrieNode()

    """
    Add a word to the data structure
    Args:
        words(str): word to be added to the data structure
    """
    def addWord(self, word: str) -> None:
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
        node.is_end_of_word = True

    """
    Search for a word in the data structure using DFS approach
    Args:
        word(str): word to search the data structure for
    Returns:
        bool: true if the word is in the data, false otherwise
    """
    def search(self, word: str) -> bool:
        def dfs(node, i):
            if i == len(word):
                return node.is_end_of_word
            char = word[i]
            if char == '.':
                for child in node.children.values():
                    if dfs(child, i + 1):
                        return True
            elif char in node.children:
                return dfs(node.children[char], i + 1)
            return False
        
        return dfs(self.root, 0)
