"""
Leetcode Challenge: Word Search II

Given an m x n board of characters and a list of strings words, 
return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells,
 where adjacent cells are horizontally or vertically neighboring. 
 The same letter cell may not be used more than once in a word.

9/8/24
Mark Robuck
"""
class TrieNode:
    def __init__(self):
        self.children = {}
        self.word = None


class Solution:
    """
    Find all words in a list given a word search board.
    Args:
        board(List[str]): given word search board
        words(List[str]): list of strings representing valid words
    Returns:
        List[str]: list of all strings found in board from words
    """
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        #build a tree from word list, words
        root = TrieNode()
        for word in words:
            node = root
            for char in word:
                if char not in node.children:
                    node.children[char] = TrieNode()
                node = node.children[char]
            node.word = word

        #depth first search
        def dfs(board, i, j, node, res):
            char = board[i][j]
            if char not in node.children:
                return
            node = node.children[char]
            if node.word:
                res.append(node.word)
                #avoid duplicate words
                node.word = None

            #mark cells as visited
            board[i][j] = '#'
            for x, y in [(i-1, j), (i+1, j), (i, j-1), (i, j+1)]:
                if 0 <= x < len(board) and 0 <= y < len(board[0]) and board[x][y] != '#':
                    dfs(board, x, y, node, res)
            #reset the cell after search
            board[i][j] = char

        #perform DFS on board
        res = []
        for i in range(len(board)):
            for j in range(len(board[0])):
                dfs(board, i, j, root, res)
        
        return res
        
