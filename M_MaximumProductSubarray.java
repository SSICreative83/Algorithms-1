public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        min[0] = nums[0];
        max[0] = nums[0];
        int res = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            min[i] = Math.min(cur, Math.min(max[i - 1] * cur, min[i - 1] * cur));
            max[i] = Math.max(cur, Math.max(max[i - 1] * cur, min[i - 1] * cur));

            res = Math.max(res, max[i]);
        }
        
        return res;
    }
}
