"""
Leetcode Challenge: Text Justification

Given an array of strings words and a width maxWidth, 
format the text such that each line has exactly maxWidth 
characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, 
pack as many words as you can in each line. Pad extra spaces ' ' 
when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. 
If the number of spaces on a line does not divide evenly between words, 
the empty slots on the left will be assigned more spaces than the 
slots on the right. For the last line of text, it should be left-justified, 
and no extra space is inserted between words.

Note:
A word is defined as a character sequence consisting of 
non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.

7/9/24
Mark Robuck
"""
class Solution:
    """
    Format a string to be evenly spaced on each line.
    Args:
        words(List[str]): list of words to be formatted
        maxWidth(int): maximum length for each line after formatting
    Returns:
        List[str]: list of sentences, where each element is a formatted line
    """
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        #empty list
        if not words:
            return [""]

        formatted_content = []
        current_line_content = []
        current_length = 0

        #loop through words
        for word in words:
            #check if next word in words will fit in remaining line width
            if len(word) + current_length + len(current_line_content) > maxWidth:
                for i in range(maxWidth - current_length):
                    #add to current line
                    current_line_content[i % (len(current_line_content) - 1 or 1)] += ' '
                #adjust remaining space on the current line and reset variables
                formatted_content.append(''.join(current_line_content))
                current_line_content = []
                current_length = 0

            #add string to line and modify available length left for line
            current_line_content.append(word)
            current_length += len(word)

        #left justify the last line
        formatted_content.append(' '.join(current_line_content).ljust(maxWidth))

        return formatted_content
