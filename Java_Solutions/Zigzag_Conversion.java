/*
* Leetcode Challenge: Zigzag Conversion
*
* The string "PAYPALISHIRING" is written in a zigzag pattern on a given 
* number of rows, where the first column contains all letters, 
* then an upward diagonal contians the next set of letters, 
* then this pattern is repeated like a backwards capital N.  
*
* P   A   H   N
* A P L S I I G
* Y   I   R
*
* And then read line by line: "PAHNAPLSIIGYIR"
* Write the code that will take a string and make this conversion 
* given a number of rows.
*
* 7/8/24
* Mark Robuck
*/
class Solution{
    /*
    * Convert a string into a zigzag format like a backwards N.
    * @params s, string to format
    * @params numRows, number of rows to use for formatting
    * @return formatted string as read from left to right
    */
    public String convert(String s, int numRows) {
        //only one row
        if (numRows == 1){
            return s;
        }
        //create a 2D array, pointer, and flag
        StringBuilder[] zigzag = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            zigzag[i] = new StringBuilder();
        }
        int currentRow = 0;
        boolean directionDown = false;

        //fill 2D array with letters from s
        for (char c : s.toCharArray()) {
            zigzag[currentRow].append(c);
            //change direction if at top or bottom row
            if (currentRow == 0 || currentRow == numRows - 1) {
                directionDown = !directionDown;
            }
            // Move up or down the rows
            if (directionDown) {
                currentRow += 1;
            } else {
                currentRow -= 1;
            }
        }
        //build a new string joining the array rows and trimming spaces
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : zigzag) {
            result.append(row);
        }

        return result.toString();
        
    }
}
