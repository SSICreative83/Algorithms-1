public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        if(A.length == 0 || B.length == 0)  return -1;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int i = 0, j = 0, ans = Integer.MAX_VALUE;
        
        while(i < A.length && j < B.length) {
            if(A[i] < B[j]) {
                ans = Math.min(B[j] - A[i], ans);
                if(i < A.length - 1) {
                    i++;
                } else {
                    j++;
                }
            } else if(A[i] > B[j]) {
                ans = Math.min(A[i] - B[j], ans);
                if(j < B.length - 1) {
                    j++;  
                } else {
                    i++;
                }
            } else {
                return 0;
            }
        }
        return ans;
    }
}
