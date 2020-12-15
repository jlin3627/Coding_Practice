class Solution 
{
    public int[] getSumAbsoluteDifferences(int[] nums) 
    {
        /*int ans[] = new int[nums.length];
        

        for (int i = 0; i<nums.length; i++)
        {
            int tmp = 0;
            for (int j = 0; j<nums.length; j++)
            {
                tmp += Math.abs(nums[i] - nums[j]);
            }
            ans[i] = tmp;
        }
        return ans;*/
        
        /*int ans[] = new int[nums.length];
        for (int i = 0; i<nums.length; i++)
        {
            for (int j = i+1; j<nums.length; j++)
            {
                System.out.println(j);
                ans[i] += Math.abs(nums[i] - nums[j]);
                ans[j] += Math.abs(nums[i] - nums[j]);
            }
        }
        return ans;*/
        
        int ans[] = new int[nums.length];
        int rightSum = 0;
        int leftSum = 0;
        for (int i = 0; i<nums.length; i++)
        {
            rightSum += nums[i];
        }
        for (int i = 0; i<nums.length; i++)
        {
            rightSum -= nums[i];
            ans[i] = rightSum - (nums[i] * (nums.length-i-1)) + (nums[i] * i - leftSum);
            leftSum += nums[i];
        }
        return ans;
        
    }
}
/*
public int[] getSumAbsoluteDifference(int[] nums)
{
    int ans[] = new int[nums.length];

    int rightSum = 0;
    int leftSum = 0;
    for (int i= 0; i<nums.lenght; i++)
    {
        rightSum += nums[i];
    }

    for (int i = 0; i<nums.length; i++)
    {
        rightSum -= nums[i];
        ans[i] = (nums[i] * i - leftSum) + (rightSum - (nums[i] * (nums.length - 1 - i) ) );
        leftSum += nums[i];
    }
    return ans;
}


public int[] getAbsoluteDifference(int[] nums)
{
    int ans[] = new int[nums.length];
    int rightSum = 0;
    int leftSum = 0;
    for (int i =0; i<nums.length; i++)
    {
        rightSum += nums[i];
    }

    for (int i = 0; i<nums.lenght; i++)
    {
        rightSum -= nums[i];
        ans[i] = (nums[i] * i - leftSum) + (rightSum - (nums[i] * (nums.length - 1 - i)));
        leftSum += nums[i];
    }
    return ans;
}

public int[] getAbsoluteDifference(int[] nums)
{
    int ans[] = new int[nums.length];
    int rightSum = 0;
    int leftSum = 0;
    for (int i =0; i<nums.length; i++)
    {
        rightSum += nums[i];
    }

    for (int i = 0; i<nums.length; i++)
    {
        rightSum -= nums[i];
        ans[i] = (nums[i] * i - leftSum) + (rightSum - (nums[i] * (nums.length -1 - i)));
        leftSum += nums[i];
    }
    return ans;
}
*/