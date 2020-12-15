/*class Solution {
    public int numWays(int n, int k) {
        // if there are no posts, there are no ways to paint them
        if (n == 0) return 0;
        
        // if there is only one post, there are k ways to paint it
        if (n == 1) return k;
        
        // if there are only two posts, you can't make a triplet, so you 
        // are free to paint however you want.
        // first post, k options. second post, k options
        if (n == 2) return k*k;
        
        int table[] = new int[n+1];
        table[0] = 0;
        table[1] = k;
        table[2] = k*k;
        for (int i = 3; i <= n; i++) {
            // the recursive formula that we derived
            table[i] = (table[i-1] + table[i-2]) * (k-1);
        }
        return table[n];
    }
}*/

/*class Solution
{
    public int numWays(int n, int k)
    {
        if (n == 0) return 0;
        if (n == 1) return k;
        if (n == 2) return k*k;
        
        int table[] = new int[n+1];
        table[0] = 0;
        table[1] = k;
        table[2] = k*k;
        for (int i = 3; i<= n; i++)
        {
            table[i] = table[i-1]*(k-1) + table[i-2]*(k-1);
        }
        return table[n];
        
    }
}
*/


/*class Solution {
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n + 1][2];
        // initialize special cases
        dp[1][0] = k;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) * (k - 1);
            dp[i][1] = dp[i - 1][0];
        }
        return dp[n][0] + dp[n][1];
    }
}*/



/*public class Solution
{
    public int numWays(int n, int k)
    {
        if (n == 0)
            return 0;
        if (n == 1)
            return k;
        int same = k;
        int diff = k * (k-1);
        
        for (int i = 3; i<=n; i++)
        {
            int prevDiff = diff;
            diff = (same + diff) * (k-1);
            same = prevDiff * 1;
        }
        
        return same + diff;
    }
}

*/

class Solution
{
    public int numWays(int n, int k )
    {
        if (n==0)
        {
            return 0;
        }
        int[][] dp = new int[n+1][2];
        dp[1][0] = k;
        for (int i = 2; i<=n; i++)
        {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1]) * (k-1);
            dp[i][1] = dp[i-1][0];
        }
        return dp[n][0] + dp[n][1];
        
    }
}
