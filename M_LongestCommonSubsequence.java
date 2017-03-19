public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        int n = A.length();
	    int m = B.length();
        
        if(m == 0 || n == 0) {
            return 0;
        }
        
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;    
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);  //doesn't count current char
                }
            }
        }
        
        return dp[m][n];
    }
}
