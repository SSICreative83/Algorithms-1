class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // 2 templates
        
        if(nums == null || nums.length == 0 || k < 0) return -1;
        return nums[helper(nums.length - k + 1, nums, 0, nums.length - 1)];
    }
    
    public int helper(int k, int[] nums, int start, int end) {
        if(start > end)    return -1;
        if(start == end && k == 1)  return nums[start];
        
        int position = partition(nums, start, end);
        if(position + 1 == k) {
            return position;
        } else if(position + 1 > k) {   //kth smallest is on left
            return helper(k, nums, start, position - 1);
        } else {    //kth smallest is on right
            return helper(k, nums, position + 1, end);
        }
        
    }
    
    public int partition(int[] nums, int start, int end) {
        if(start >= end) {
            return start;
        }
        int left = start, right = end;
        int pivot = nums[left];
        
        while(left < right) {
            while(left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while(left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
    
    public void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
};
