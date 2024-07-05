"""
Leetcode Challenge: Integer to Roman

Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral 
has the following rules:
If the value does not start with 4 or 9, select the symbol of the maximal value 
that can be subtracted from the input, append that symbol to the result, 
subtract its value, and convert the remainder to a Roman numeral.
If the value starts with 4 or 9 use the subtractive form representing one 
symbol subtracted from the following symbol, for example, 4 is 1 (I) less 
than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following 
subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 
400 (CD) and 900 (CM).
Only powers of 10 (I, X, C, M) can be appended consecutively at most 
3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), 
or 500 (D) multiple times. If you need to append a symbol 4 times 
use the subtractive form. Given an integer, convert it to a Roman numeral.

7/5/24
Mark Robuck
"""
class Solution:
    """
    Given an integer, convert it to a Roman numberal.
    Args:
        num(int): integer to be converted to roman numeral
    Returns:
        str: roman numeral version of the given integer as a string
    """
    def intToRoman(self, num: int) -> str:
        result = ""
        n = num
        #empty string
        if not num:
            return "0"
        #loop through the num and convert to roman values
        while n > 0:
            if (n % 1000 == 0):
                result += "M"
                n -= 1000
            elif (n % 500 == 0):
                result += "D"
                n -= 500
            elif (n % 100 == 0):
                result += "C"
                n -= 100
            elif (n % 50 == 0):
                result += "L"
                n -= 50
            elif (n % 10 == 0):
                result += "X"
                n -= 10
            elif (n % 5 == 0):
                result += "V"
                n -= 5
            elif (n % 1 == 0):
                result += "I"
                n -= 1
        #reverse the string
        result = result[::-1]
        #replace 4s and 9s with shortened versions
        result = result.replace("DCCCC", "CM")
        result = result.replace("CCCC", "CD")
        result = result.replace("LXXXX", "XC")
        result = result.replace("XXXX", "XL")
        result = result.replace("VIIII", "IX")
        result = result.replace("IIII", "IV")
        return result

  """
  I tried to use a mapping for this but got stuck.  A more efficient solution would have been the following:
  numerals_table = [
            [1,    'I'],
            [4,   'IV'],
            [5,    'V'],
            [9,   'IX'],
            [10,   'X'],
            [40,  'XL'],
            [50,   'L'],
            [90,  'XC'],
            [100,  'C'],
            [400, 'CD'],
            [500,  'D'],
            [900, 'CM'],
            [1000, 'M'],
        ]
        
        numeral = []
        for s in numerals_table[::-1]:
            while num >= s[0]:
                numeral.append(s[1])
                num -= s[0]
        
        return ''.join(numeral)
  """
