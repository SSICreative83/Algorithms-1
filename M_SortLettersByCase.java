public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
         int start = 0, end = chars.length - 1;
        
        while(start <= end) {
            while(start <= end && isLowerCase(chars[start])) {
                start++;
            }
            while(start <= end && !isLowerCase(chars[end])) {
                end--;
            }
            if(start < end) {
                swap(chars, start, end);
            }
        }
    }
    
    public boolean isLowerCase(char c) {
        return c - 'a' >= 0 && c - 'z' <= 0;
    }
        
    public void swap(char[] nums, int i, int j) {
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
