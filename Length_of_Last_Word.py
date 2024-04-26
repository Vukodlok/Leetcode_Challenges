class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        #split the string into 'words' and store in an array
        words = s.split()
        #grab the last index in the array
        lastWord = words[len(words)-1]
        #find the length and print the results
        return len(lastWord)
