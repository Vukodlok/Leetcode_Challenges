class Solution:
    def isHappy(self, n: int) -> bool:
        #used to store current iteration of happy number calculation
        result = n
        #used to store a set of already seen numbers from result
        repeats = set()
        #loop until result is 1 or pattern repeats
        while (result != 1 and result not in repeats):
            #add result to the reapeats set
            repeats.add(result)
            #split the number into digits
            digits = list(map(int, str(result)))
            #clear result for storing new int after calculation
            result = 0
            #perform squaring and sum
            for num in digits:
                result += num**2
        if result == 1:
            return True
        return False

'''
A more efficient end to this based on solution code I looked at afterwards would be
return result == 1
'''
