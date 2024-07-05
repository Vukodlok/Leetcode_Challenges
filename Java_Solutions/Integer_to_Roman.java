/*
* Leetcode Challenge: Integer to Roman
*
* Roman numerals are formed by appending the conversions of decimal 
* place values from highest to lowest. Converting a decimal place 
* value into a Roman numeral has the following rules:
* If the value does not start with 4 or 9, select the symbol of the 
* maximal value that can be subtracted from the input, 
* append that symbol to the result, 
* subtract its value, and convert the remainder to a Roman numeral.
* If the value starts with 4 or 9 use the subtractive form representing one 
* symbol subtracted from the following symbol, for example, 4 is 1 (I) less 
* than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following 
* subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 
* 400 (CD) and 900 (CM).
* Only powers of 10 (I, X, C, M) can be appended consecutively at most 
* 3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), 
* or 500 (D) multiple times. If you need to append a symbol 4 times 
* use the subtractive form. Given an integer, convert it to a Roman numeral.
*
* 7/5/24
* Mark Robuck
*/
class Solution{
    /*
    * Given an integer, convert it to a Roman numberal.
    * @prams num, integer to be converted to roman numeral
    * @return roman numeral version of the given integer as a string
    */
    public String intToRoman(int num) {
        //set up mapping of integer to roman numerals
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        //use stringbuilder for mutable strings
        StringBuilder numeral = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                // Find the element in our mapping, append the string value
                numeral.append(symbols[i]);
                // Subtract the integer value in our mapping from num
                num -= values[i];
            }
        }
        return numeral.toString();
    }
}
/* 
* I solved this first in Python.  I wanted to use a mapping but was
* unable to get a working solution that way.  After viewing other solutions
* in Python I attempted a mapping with my Java solution. 
*/
