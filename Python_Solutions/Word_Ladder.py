"""
Leetcode Challenge: Word Ladder

A transformation sequence from word beginWord to word endWord using 
a dictionary wordList is a sequence of words 
beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord 
does not need to be in wordList.
sk == endWord

Given two words, beginWord and endWord, and a dictionary wordList, 
return the number of words in the shortest transformation sequence 
from beginWord to endWord, or 0 if no such sequence exists.

9/5/24
Mark Robuck
"""
from collections import deque

class Solution:
    """
    Find the minimum number of single letter transformations needed to change one word to another given a dictionary of valid changes.
    Args:
        beginWord(str): starting string
        endWord(str): ending string
        wordList(List[str]): list of valid string transformations
    Returns:
        int: minimum number of valid transformations needed to get from beginWord to endWord
    """
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        #endWord not in the valid list wordList
        wordSet = set(wordList)
        if endWord not in wordSet:
            return 0

        #BFS with word and step count
        queue = deque([(beginWord, 1)])
        while queue:
            currentWord, steps = queue.popleft()

            #check each letter in the current word
            for i in range(len(currentWord)):
                #try replacing the i-th letter with every letter from a-z
                for char in 'abcdefghijklmnopqrstuvwxyz':
                    nextWord = currentWord[:i] + char + currentWord[i+1:]
                    
                    if nextWord == endWord:
                        return steps + 1
                    
                    if nextWord in wordSet:
                        #mark this word as visited
                        wordSet.remove(nextWord)
                        queue.append((nextWord, steps + 1))
        
        return 0
        
