public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int i = 0, j = nums.length - 1;
        while(i <= j) {     //notice <=
            while(i <= j && nums[i] < k) {  //notice <=
                i++;
            }
            while(j >= i && nums[j] >= k) { //notice >=
                j--;
            }
            if(i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        return i;
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
