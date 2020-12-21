class Solution 
{
    
    /*
    public int lengthOfLIS(int[] nums) 
    {
        return find(nums, Integer.MIN_VALUE, 0);
    }
    
    public int find(int[] nums, int prev, int pos)
    {
        if (pos == nums.length)
        {
            return 0;
        }
        int use = 0;
        if (nums[pos] > prev)
        {
            use = 1+ find(nums,nums[pos], pos+1);
        }
        int notUse = find(nums, prev, pos+1);
        return Math.max(use,notUse);
    }
    
    */
    /*public int dp[][]; 
    public int lengthOfLIS(int[] nums) 
    {
        dp = new int[nums.length + 1][nums.length];
        for (int[] l : dp)
        {
            Arrays.fill(l,-1);
        }
        return find(nums, -1,0);
    }
    
    public int find(int[] nums, int prev, int cur)
    {
        if (cur == nums.length)
        {
            return 0;
        }
        
        if (dp[prev+1][cur] >= 0) return dp[prev+1][cur];
        int use = 0;
        if (prev < 0 || nums[cur] > nums[prev])
        {
            use = 1+ find(nums,cur, cur+1);
        }
        int notUse = find(nums, prev, cur+1);
        dp[prev+1][cur] = Math.max(use,notUse);
        return dp[prev+1][cur];
    }*/
    
    
    /*public int lengthOfLIS(int[] nums)
    {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num:nums)
        {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i<0)
            {
                System.out.println(i);
                i = -(i+1);
                System.out.println(i);
            }
            dp[i] = num;
            if (i == len)
            {
                len++;
            }
        }
        return len;
    }*/
    

    // binary search
    public int lengthOfLIS(int[] nums) 
    {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) 
        {
            int i = 0, j = size;
            while (i != j) 
            {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
    
}


/*
// dp
https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/

class Solution {
    public int lengthOfLIS(int[] nums) 
    {
        int n = nums.length;
        int dp[] = new int[n];
        int max = 0;
        for (int i = 0; i<n; i++)
        {
            dp[i] = 1;
        }
        
        for ( int i = 1; i<n; i++)
        {
            for (int j=0;j<i;j++)
            {
                if (nums[i] > nums[j] && (dp[i] < dp[j]+1) )
                {
                    dp[i] = dp[j]+1;
                }
            }
        }
        for (int i = 0; i<n; i++)
        {
            if (max<dp[i])
            {
                max = dp[i];
            }
        }
        return max;
    }
}

*/

