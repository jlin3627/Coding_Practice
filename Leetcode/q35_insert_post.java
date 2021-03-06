class Solution 
{
    public int searchInsert(int[] nums, int target) 
    {
        int start = 0, end = nums.length;
        int mid = start + (end - start) / 2;
        int ans;
        while (start<end)
        {
            if (nums[mid] == target) return mid;
            else if (target<nums[mid]) end = mid;
            else start = mid+1;
            mid = start + (end-start)/2;
        }
        return mid;
    }
    
}