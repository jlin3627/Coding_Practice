class Solution 
{
    public int minSubArrayLen(int s, int[] nums) 
    {
        int n = nums.length;
        if (n==0) return 0;
        int ans = Integer.MAX_VALUE, i = 0, j = 0;
        int tmpSum = 0;
        int count = 0;
        while (i<n && j<n)
        {
            if (tmpSum<s)
            {
                tmpSum+=nums[j];
                j++;
                count++;
            }
            else
            {
                if (count<ans) ans = count;
                tmpSum-=nums[i];
                i++;
                count--;
            }
        }
        while (i<n && tmpSum>=s)
        {
            if (count<ans) ans = count;
            tmpSum-=nums[i];
            i++;
            count--;
        }
        if (ans == Integer.MAX_VALUE) ans = 0;
        return ans;
    }
}

class Solution
{
    public int minSubArrayLen(int s, int[] nums)
    {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= s) 
            {
                ans = Math.min(ans, i + 1 - left);
                sum -= nums[left];
                left++;
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }
}
