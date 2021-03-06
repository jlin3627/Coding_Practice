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

class Solution {
    public int crossSum(int[] nums, int left, int right, int p) {
      if (left == right) return nums[left];
  
      int leftSubsum = Integer.MIN_VALUE;
      int currSum = 0;
      for(int i = p; i > left - 1; --i) {
        currSum += nums[i];
        leftSubsum = Math.max(leftSubsum, currSum);
      }
  
      int rightSubsum = Integer.MIN_VALUE;
      currSum = 0;
      for(int i = p + 1; i < right + 1; ++i) {
        currSum += nums[i];
        rightSubsum = Math.max(rightSubsum, currSum);
      }
  
      return leftSubsum + rightSubsum;
    }
  
    public int helper(int[] nums, int left, int right) {
      if (left == right) return nums[left];
  
      int p = (left + right) / 2;
  
      int leftSum = helper(nums, left, p);
      int rightSum = helper(nums, p + 1, right);
      int crossSum = crossSum(nums, left, right, p);
  
      return Math.max(Math.max(leftSum, rightSum), crossSum);
    }
  
    public int maxSubArray(int[] nums) {
      return helper(nums, 0, nums.length - 1);
    }
  }