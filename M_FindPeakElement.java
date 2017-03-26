class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
     
     //This problem is binary search type 2: half half: discard half that doesn't contain result
    public int findPeak(int[] A) {
        // write your code here
        int start = 1, end = A.length-2; // 1.答案在之间，2.不会出界 
        while(start + 1 <  end) {
            int mid = (start + end) / 2;
            if(A[mid] < A[mid - 1]) {
                end = mid - 1;
            } else if(A[mid] < A[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if(A[start] > A[end]) {
            return start;
        } else { 
            return end;
        }
    }
}
