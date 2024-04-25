class Solution:
    def romanToInt(self, s: str) -> int:
        #create mapping of roman numerals to integer values
        romanValues = {'I':1, "V":5, "X":10, "L":50, "C":100, "D":500, "M":1000}
        total = 0 #total value of integer

        #loop through the given string using while to manage index incrementing
        i = 0
        while i < len(s):
            current = romanValues[s[i]]
            if i < len(s)-1:
                nextRoman = romanValues[s[i+1]]
                #look for subtraction pattern
                if current < nextRoman:
                    total += nextRoman - current
                    i += 2 #skip next character
                    continue
            #if not part of a subtraction pattern add to the total
            total += current
            i += 1
        return total
