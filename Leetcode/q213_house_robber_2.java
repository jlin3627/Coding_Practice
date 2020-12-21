/*class Solution {
    public int rob(int[] nums) 
    {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums,0,nums.length-2), rob(nums,1,nums.length-1));
    }
    
    public int rob(int[] nums, int start, int end)
    {
        int preRob = 0, preNotRob = 0, rob = 0, notRob = 0;
        for (int i = start; i<=end; i++)
        {
            rob = preNotRob + nums[i];
            notRob = Math.max(preRob, preNotRob);
            
            preNotRob = notRob;
            preRob = rob;
        }
        return Math.max(rob,notRob);
    }
    
    
}*/


// https://www.youtube.com/watch?v=mFT2bIFKUFE
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }
    
    private int rob(int[] nums, int start, int end) {
        int prevTwo = 0, prevOne = 0, max = 0;
        for(int i = start; i < end; i++) {
            max = Math.max(prevTwo + nums[i], prevOne);
            prevTwo = prevOne;
            prevOne = max;
        }
        return max;
    }
}

/*class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2, new Integer[nums.length]), rob(nums, 1, nums.length - 1, new Integer[nums.length]));
    }
    
    private int rob(int[] nums, int st, int i, Integer[] dp) {
        if(i < st) return 0;
        if(dp[i] != null) return dp[i];
        return dp[i] = Math.max(rob(nums, st, i - 2, dp) + nums[i], rob(nums, st, i - 1, dp));
    }
}*/
/*
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }
    
    private int rob(int[] nums, int start, int end){
        int[] numsNew = Arrays.copyOfRange(nums, start, end + 1);
        int[] dp = new int[numsNew.length];
        if(numsNew.length == 0) return 0;
        if(numsNew.length == 1) return numsNew[0];
        dp[0] = numsNew[0];
        dp[1] = Math.max(numsNew[0], numsNew[1]);
        for(int i = 2; i < numsNew.length; i++){
            dp[i] = Math.max(dp[i - 2] + numsNew[i], dp[i - 1]);
        }
        return dp[numsNew.length - 1];
        
    }
}*/