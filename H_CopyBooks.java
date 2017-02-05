public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if(pages == null || pages.length == 0)  return 0;
        int left = 0, right = 0;
        for(int i = 0; i < pages.length; i++) {
            left = Math.max(left, pages[i]);
            right += pages[i];
        }
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(check(mid, pages) <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        if(check(left, pages) <= k) {
            return left;
        }
        return right;
    }
    public int check(int time, int[] pages) {
        int k = 0, total = 0;
        for(int i = 0; i < pages.length; i++) {
            if(total + pages[i] > time) {
                k++; 
                total = 0;
            }
            total += pages[i];
        }
        
        return k + (total > 0 ? 1:0);
    }
}
