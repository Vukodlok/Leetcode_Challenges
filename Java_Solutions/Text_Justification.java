/*
* Leetcode Challenge: Text Justification
*
* Given an array of strings words and a width maxWidth, 
* format the text such that each line has exactly maxWidth 
* characters and is fully (left and right) justified.
* You should pack your words in a greedy approach; that is, 
* pack as many words as you can in each line. Pad extra spaces ' ' 
* when necessary so that each line has exactly maxWidth characters.
*
* Extra spaces between words should be distributed as evenly as possible. 
* If the number of spaces on a line does not divide evenly between words, 
* the empty slots on the left will be assigned more spaces than the 
* slots on the right. For the last line of text, it should be left-justified, 
* and no extra space is inserted between words.
*
* Note:
* A word is defined as a character sequence consisting of 
* non-space characters only.
* Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
* The input array words contains at least one word.
*
* 7/9/24
* Mark Robuck
*/
import java.util.ArrayList;
import java.util.List;

class Solution{
    /*
    * Format a string to be evenly spaced on each line.
    * @params words, list of strings to be formatted
    * @params maxWidth, maximum length for each line after formatting
    * @return list of sentences, where each element is a formatted line
    */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> formattedContent = new ArrayList<>();
        List<String> currentLineContent = new ArrayList<>();
        int currentLength = 0;

        for (String word : words) {
            //check if next word in words will fit in remaining line width
            if (currentLength + word.length() + currentLineContent.size() > maxWidth) {
                //add spaces to current line
                int totalSpaces = maxWidth - currentLength;
                int numberOfGaps = currentLineContent.size() - 1;
                StringBuilder line = new StringBuilder();

                //adjust remaining space on the current line and reset variables
                if (numberOfGaps == 0) {
                    line.append(currentLineContent.get(0));
                    addSpaces(line, totalSpaces);
                } else {
                    int spacePerGap = totalSpaces / numberOfGaps;
                    int extraSpaces = totalSpaces % numberOfGaps;
                    for (int i = 0; i < numberOfGaps; i++) {
                        line.append(currentLineContent.get(i));
                        addSpaces(line, spacePerGap + (i < extraSpaces ? 1 : 0));
                    }
                    line.append(currentLineContent.get(numberOfGaps));
                }

                formattedContent.add(line.toString());
                currentLineContent.clear();
                currentLength = 0;
            }

            //add string to line and modify available length left for line
            currentLineContent.add(word);
            currentLength += word.length();
        }

        //left justify the last line
        StringBuilder lastLine = new StringBuilder();
        for (String word : currentLineContent) {
            lastLine.append(word).append(" ");
        }
        //remove the last space
        lastLine.deleteCharAt(lastLine.length() - 1);
        while (lastLine.length() < maxWidth) {
            lastLine.append(" ");
        }
        formattedContent.add(lastLine.toString());

        return formattedContent;
    }

    /*
    * Add spaces to string content.
    * @params sb, String to add spaces to
    * @params count, amount of space to add
    */
    private void addSpaces(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }
    }
}
