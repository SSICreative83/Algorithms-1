public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here;
        int start = 0, end = nums.length - 1;
        
        while(start <= end) {
            while(start <= end && nums[start] % 2 == 1) {
                start++;
            }
            while(start <= end && nums[end] % 2 == 0) {
                end--;
            }
            if(start < end) {
                swap(nums, start, end);
            }
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
