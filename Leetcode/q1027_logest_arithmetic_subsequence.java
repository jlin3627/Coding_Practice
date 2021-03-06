class Solution {
    public int longestArithSeqLength(int[] A) 
    {
         int res = 2, n = A.length;
         HashMap<Integer, Integer>[] dp = new HashMap[n];
         for (int j = 0; j < A.length; j++) 
         {
             dp[j] = new HashMap<>();
             for (int i = 0; i < j; i++) {
                 int d = A[j] - A[i];
                 dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);
                 res = Math.max(res, dp[j].get(d));
             }
         }
         return res;
     }
 }
 
 class Solution 
 {
    public int longestArithSeqLength(int[] A) {
    int n = A.length, ans = 0;
    int[][] dp = new int[n][n];
    int[] last = new int[1001];
    for(int i = 0; i < n; i++) {
        for(int j = i+1; j < n; j++) {
            int prev = (A[i] << 1) - A[j];
            if(prev >= 0 && last[prev] != 0) {
                dp[i][j] = dp[last[prev] - 1][i] + 1;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        last[A[i]] = i+1;
    }
    return ans + 2;
}
}

/*


class Solution
{
    public int longestArithSeqLength(int[] A)
    {
        int res = 2, n = A.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int j = 0; j<a.length; j++)
        {
            dp[j] = new HashMap<>();
            for (int i = 0; i<j; i++)
            {
                int d = A[j] - A[i];
                dp[j].put(d,dp[i].getOrDefault(d,1) + 1);
                res = Math.max(res,dp[j].get(d));
            }
        }
        return res;
    }

}
*/