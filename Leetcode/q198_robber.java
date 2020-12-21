class Solution {
    public int rob(int[] nums) 
    {
        if (nums.length == 0)
        {
            return 0;
        }
        if (nums.length < 2)
        {
            return nums[0];
        }
        
        if (nums.length == 2)
        {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        
        for (int i = 2; i<nums.length; i++)
        {
            if (i== 2) nums[i] += nums[i-2];
            else
            {
                nums[i] += Math.max(nums[i-2], nums[i-3]);
            }
        }
        
        return nums[nums.length-1] > nums[nums.length-2]? nums[nums.length-1]:nums[nums.length-2];
    }
}