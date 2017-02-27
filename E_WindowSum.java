public class Solution {
    /**
     * @param nums a list of integers.
     * @return the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if(nums == null || nums.length == 0 || k <= 0 || nums.length < k) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }
        res[0] = sum;
        for(int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];    
            res[i - k + 1] = sum;
        }
        return res;
    }
}

