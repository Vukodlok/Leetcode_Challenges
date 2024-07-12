/*
* Leetcode Challenge: Container with Most Water
*
* You are given an integer array height of length n. 
* There are n vertical lines drawn such that the two endpoints 
* of the ith line are (i, 0) and (i, height[i]).
* Find two lines that together with the x-axis form a container, 
* such that the container contains the most water.
* Return the maximum amount of water a container can store.
* Notice that you may not slant the container.
*
* 7/11/24
* Mark Robuck
*/
class Solution{
    /*
    * Find the max amount of area given an area of heights.
    * @params height, list of heights to contain water
    * @return max amount of water able to be held between two "walls"
    */
    public int maxArea(int[] height) {
        //if one or less heights in list
        if (height.length < 2){
            return 0;
        } 
        int left= 0;
        int right = height.length - 1;
        int max_area = 0;
        
        while (left < right){
            //calculate width between left and right pointers
            int width = right - left;
            //calculate width between left and right heights
            int current_area = Math.min(height[left], height[right]) * width;
            //check if current area is the new max
            max_area = Math.max(max_area, current_area);
            //move the shorter pointer
            if (height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max_area;
    }
}
