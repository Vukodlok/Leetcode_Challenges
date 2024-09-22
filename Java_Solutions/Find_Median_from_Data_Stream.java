/*
* Leetcode Challenge: Find Median from Data Stream
*
* The median is the middle value in an ordered integer list. 
* If the size of the list is even, there is no middle value, 
* and the median is the mean of the two middle values.
*
* For example, for arr = [2,3,4], the median is 3.
* For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
*
* Implement the MedianFinder class:
*
* MedianFinder() initializes the MedianFinder object.
* void addNum(int num) adds the integer num from the data stream 
* to the data structure.
* double findMedian() returns the median of all elements so far. 
* Answers within 10-5 of the actual answer will be accepted.
*
* 9/22/24
* Mark Robuck
*/

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    //initialize 2 heaps for smaller and larger half of data
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }
    
    //add integer num from data stream to data structure
    public void addNum(int num) {
        maxHeap.offer(num);
        //ensure max largest number smaller than smallest min.
        if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.offer(maxHeap.poll());
        }
        //balance the number oif elements in heaps, extra goes to max
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }  
    
    //calculate the median
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
        //if max_heap has more elements
        return maxHeap.peek();
        } else {
        //if even number of elements
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}
