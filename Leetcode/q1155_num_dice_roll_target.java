/*class Solution {
    public int numRollsToTarget(int d, int f, int target) 
    {
        if (d == 0) return 0;
        long ans = 0;
        for (int i = 1; i<=f; i++)
        {
            if (i == target) return 1;
            else if (i>target) return 0;
            else if (i<target)
            {
                ans+=numRollsToTarget(d-1, f, target - i);
            }
        }
        return (int)(ans%(1000000007));
    }
}*/

/*class Solution {
    
    private static final int md = 1000000007;
    private Map<String, Integer> mp = new HashMap<>();
   public int numRollsToTarget(int d, int f, int target) 
    {
        if (d == 0 && target == 0)
        {
            return 1;
        }
       if (d<=0 || target <=0)
       {
           return 0;
       }
       String key = d + "_" + target;
       if (mp.containsKey(key))
       {
           return mp.get(key);
       }
       
       int ans = 0;
       for (int i = 1; i<=f && i<=target; i++)
       {
           ans = (ans + numRollsToTarget(d-1, f, target - i)) % md;
       }
       
       mp.put(key, ans);
       return ans;
    }   
}*/

class Solution
{
    public int numRollsToTarget(int d, int f, int target)
    {
        int[][] dp = new int[d+1][target +1];
        dp[0][0] = 1;
        int md = 1000000007;
        
        for (int i =1;i<=d; i++)
        {
            for (int j = 1; j<=target; j++)
            {
                if (j>i*f) break;
                for (int k = 1; k<=f && k<=j; k++)
                {
                    dp[i][j] = (dp[i][j] + dp[i-1][j-k]) %md;
                }
            }
        }
        return dp[d][target];
    }
}

/*
Practice

class Solution
{
    private static final int md = 1000000007;
    private Map<String, Integer> mp = new HashMap<>();
    public int numRollsToTarget(int d, int f, int target)
    {
        if (d==0 && target == 0)
        {
            return 1;
        }
        if (d<=0 || target <=0)
        {
            return 0;
        }
        String key = d+ "_" + target;
        if (mp.containsKey(key)
        {
            return mp.get(key);
        }

        int ans = 0;
        for (int i =1; i<=f && i<=target; i+++)
        {
            ans = (ans+ numRollsToTarget(d-1, f, target-i))%md;
        }
        
        mp.put(key,ans);
        return ans;
    }
}

class Solution
{
    private static final int md = 100000007;
    private Map<String, Integer> mp = new HashMap<>();
    public int numRollsToTarget(int d, int f, int target)
    {
        if (d==0 && target == 0)
        {
            return 1;
        }
        if (d<=0 || target <=0)
        {
            return 0;
        }
        String key = d+"_" + target;
        if (mp.containsKey(key)
        {
            return mp.get(key);
        }

        int ans = 0;
        for (int i = 1; i<= f && i<=target; i++)
        {
            ans = (ans + numRollsToTarget(d-1, f, target-i))%md;
        }

        mp.put(key,ans);
        return ans;
    }
}

class Solution
{
    private static final int md = 1000000007;
    private Map<String, Integer> mp = new HashMap<>();
    public int numRollsToTarget(int d, int f, int target)
    {
        if (d==0 && target == 0)
        {
            return 1;
        }
        if (d<=0 || target<=0)
        {
            return 0;
        }
        String key = d+"_" + target;
        if(mp.containsKey(key)
        {
            return mp.get(key);
        }

        int ans = 0;
        for (int i == 1; i<=f && i<=target; i++)
        {
            ans = (ans + numRollsToTarget(d-1, f,target-i))%md;
        }

        mp.put(key,ans);
        return ans;
    }
}

*/

/*
class Solution
{
    public int numRollsToTarget(int d, int f, int target)
    {
        int[][] dp = new int[d+1][target +1];
        dp[0][0] = 1;
        int md = 1000000007;
        
        for (int i =1;i<=d; i++)
        {
            for (int j = 1; j<=target; j++)
            {
                if (j>i*f) break;
                for (int k = 1; k<=f && k<=j; k++)
                {
                    dp[i][j] = (dp[i][j] + dp[i-1][j-k]) %md;
                }
            }
        }
        return dp[d][target];
    }
}

class Solution
{
    public int numRollsToTarget(int d, int f, int target)
    {
        int[][] dp = new int[d+1][target + 1];
        dp[0][0] = 1;
        int md = 1000000007;

        for (int i = 1; i<=d; i++)
        {
            for (int j = 1; j<= target; j++)
            {
                if(j>i*f) break;
                for (int k =1; k<=f && k<=j; k++)
                {
                    dp[i][j] = (dp[i][j] + dp[i-1][j-k])%md;
                }
            }
        }
        return dp[d][traget];
    }
}

class Solution
{
    public int numRollsToTarget(int d, int f, int target)
    {
        int[][] dp = new int[d+1][target+1];
        dp[0][0] = 1;
        int md = 100000007;

        for (int i = 1; i<=d; i++)
        {
            for (int j = 1; j<=target; j++)
            {
                if(j>i*f) break;
                for (int k - 1; k<=f && k<=j; k++)
                {
                    dp[i][j] = (dp[i][j] + dp[i-1][j-k])%md;
                }
            }
        }
        return dp[d][target];
    }
}

class Solution
{
    public int numRollsToTarget(int d, int f, int target)
    {
        int[][] dp = new int[d+1][target+1];
        int md = 1000000007;

        for (int i =1; i<=d; i++)
        {
            for (int j = 1; j<= target; j++)
            {
                if (j>i*f) break;
                for(int k -1; k<=f && k<=j; k++)
                {
                    dp[i][j] = (dp[i][j] + dp[i-1][j-k])%md;
                }
            }
        }
        return dp[d][target];
    }
}



*/