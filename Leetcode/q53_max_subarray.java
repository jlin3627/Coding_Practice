class Solution {
    /*public int maxSubArray(int[] nums) {
     int[] dp = new int[nums.length];
        long ans = Integer.MIN_VALUE;
        long tmpSum = 0;
        for (int i = 0; i<nums.length; i++)
        {
            tmpSum += nums[i];
            long subSum = tmpSum;
            if (subSum>ans) ans = subSum;
            for (int j = 0; j<i;j++)
            {
                subSum -= nums[j];
                if (subSum > ans) ans = subSum;
            }
        }
        
        return (int) ans;
        
    }*/
    /*public int maxSubArray(int[] nums)
    {
        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];
        for (int i = 1; i<n; ++i)
        {
            currSum = Math.max(nums[i], currSum+nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }*/
    public int maxSubArray(int[] nums)
    {
        int n = nums.length, maxSum = nums[0];
        for (int i = 1; i<n; ++i)
        {
            if (nums[i-1] > 0) nums[i] += nums[i-1];
            maxSum = Math.max(nums[i], maxSum);
            //System.out.println(nums[i]);
        }
        
        return maxSum;
    }
}