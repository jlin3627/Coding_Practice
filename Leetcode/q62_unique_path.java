class Solution {
    public int uniquePaths(int m, int n) 
    {
        if (m*n <=2) return 1;
        long[][] dp = new long[m+1][n+1];
        /*for (int i = 0; i<m;i++)
        {
            dp[i][0] = 1;
        }
        for (int j = 0; j<n; j++)
        {
            dp[0][j] = 1;
        }*/
        
        //dp[0][0] = 1;
        //dp[0][1] = 1;
        //dp[1][0] = 1;
        //dp[1][1] = 1;
        
        for (int i = 1; i<=m; i++)
        {
            for (int j = 1; j<=n; j++)
            {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return (int)(dp[m][n] / 2);
    }
}

/*
class Solution {
    public int uniquePaths(int m, int n) 
    {
        if (m == 1 || n==1)
        {
            return 1;
        }
        return uniquePaths(m-1, n) + uniquePaths(m,n-1);
    }
}
*/

class Solution {
    public int uniquePaths(int m, int n) 
    {
        int[][] dp = new int[m][n];
        
        for (int i = 0; i<m; i++)
        {
             dp[i][0] = 1;
        }
       for (int j = 0; j<n; j++)
        {
            dp[0][j] = 1;
        }
        for (int i = 1; i<m; i++)
        {
            for (int j = 1; j<n; j++)
            {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}

