class Solution {
    public int removeElement(int[] nums, int val) {
        //create left and right pointers
        int left = 0;
        int right = nums.length - 1;
        //loop through initial list
        while (left <= right) {
            //check for val
            if (nums[left] == val) {
                //replace val in nums
                nums[left] = nums[right];
                right--;
            }
            else {
                left++;
            }
        }
        return left;
    }
}
