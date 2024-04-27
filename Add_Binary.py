class Solution:
    def addBinary(self, a: str, b: str) -> str:
        #convert strings to binary using integer casting of base 2
        binaryA = int(a, 2)
        binaryB = int(b, 2)
        #use binary addition and convert back to string
        binarySum = bin(binaryA + binaryB)
        #strip the "0b" portion from the front of the string
        result = binarySum[2:]
        return result
