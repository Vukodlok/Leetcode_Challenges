"""
Leetcode Challenge: Find Median from Data Stream

The median is the middle value in an ordered integer list. 
If the size of the list is even, there is no middle value, 
and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.

Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream 
to the data structure.
double findMedian() returns the median of all elements so far. 
Answers within 10-5 of the actual answer will be accepted.

9/22/24
Mark 
"""

# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()

import heapq

class MedianFinder:

    #initialize 2 heaps for smaller and larger half of data
    def __init__(self):
        self.max_heap = []
        self.min_heap = []
        
    #add integer num from data stream to data structure
    def addNum(self, num: int) -> None:
        heapq.heappush(self.max_heap, -num)
        #ensure max largest number smaller than smallest min.
        if self.max_heap and self.min_heap and (-self.max_heap[0] > self.min_heap[0]):
            heapq.heappush(self.min_heap, -heapq.heappop(self.max_heap))

        #balance the number oif elements in heaps, extra goes to max
        if len(self.max_heap) > len(self.min_heap) + 1:
            heapq.heappush(self.min_heap, -heapq.heappop(self.max_heap))
        elif len(self.min_heap) > len(self.max_heap):
            heapq.heappush(self.max_heap, -heapq.heappop(self.min_heap))
        
    #calculate the median
    def findMedian(self) -> float:
        if len(self.max_heap) > len(self.min_heap):
            #if max_heap has more elements
            return -self.max_heap[0]  
        #if even number of elements
        return (-self.max_heap[0] + self.min_heap[0]) / 2
