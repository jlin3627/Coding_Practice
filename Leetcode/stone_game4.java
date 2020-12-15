class Solution {
    /*public int stoneGameVII(int[] stones) 
    {
        int n = stones.length;
        int[] preSum = new int[n];
        preSum[0] = stones[0];
        for (int i = 1; i<n; i++)
        {
            preSum[i] += preSum[i-1] + stones[i];
        }
        int[][] dp = new int[n][n];
        for (int len = 1; len<n; len++)
        {
            for (int i = 0; i+len<n; i++)
            {
                int j = i+len;
                dp[i][j] = preSum[j-1] - (i==0?0:preSum[i-1]) - dp[i][j-1];
                
                if (dp[i][j] < preSum[j] - preSum[i] - dp[i+1][j])
                {
                    dp[i][j] = preSum[j] - preSum[i] -dp[i+1][j];
                }
                
                for (int ii = 0; ii<n; ii++)
                {
                    for (int jj = 0; jj<n; jj++)
                    {
                        System.out.print(" ");
                        System.out.print(Integer.toString(dp[ii][jj]));
                    }
                    System.out.println();
                }
                System.out.println();

            }
        }
        
        
        return dp[0][n-1];
    }*/
    
    
    public int stoneGameVII(int[] stones) {
        if (stones.length == 1) return 0;
        int l = stones.length;
        int[] pre = new int[l+1];
        for (int i = 1; i <= l; i++) pre[i] = pre[i-1] + stones[i-1];
        
        int[][] dp = new int[l][l];
        for (int i = l-2; i >= 0; i--) {
            for (int j = i+1; j < l; j++) {
                if (i == j-1) {
                    dp[i][j] = Math.max(stones[i], stones[j]);
                } else {
                    dp[i][j] = Math.max(pre[j+1]-pre[i+1]-dp[i+1][j], pre[j]-pre[i]-dp[i][j-1]);
                }
            }
        }
        /* for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        } */
        return dp[0][l-1];
    }

    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[][] dp = new int[n][n];
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + stones[i];
        }
        for (int l = 2; l <= n; l++) {
            for (int start = 0; start + l - 1 < n; start++) {
                int end = start + l - 1;
                dp[start][end] = Math.max(sum[end + 1] - sum[start + 1] - dp[start + 1][end],
                        sum[end] - sum[start] - dp[start][end - 1]);

            }
        }
        return dp[0][n - 1];
    }
}