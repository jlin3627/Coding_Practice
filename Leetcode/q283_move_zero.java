class Solution {
    public void moveZeroes(int[] nums) 
    {
        int curr = 0;
        int count = 0;
        for (int i = 0; i<nums.length;i++)
        {
            if (nums[i] != 0)
            {
                if (i!=curr)
                {
                   nums[curr] = nums[i];
                    nums[i] = 0; 
                }
                 curr++;
                
            }
        }
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        int j = nums.length;
        int count = 0;
        for(int i = 0; i<j; i++)
        {
            if( nums[i]!=0 )
            {
                nums[count++] = nums[i];
            }
        }
        while (count< nums.length)
        {
            nums[count++] = 0;
        }
    }
}