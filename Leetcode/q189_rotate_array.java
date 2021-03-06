class Solution 
{
    public void rotate(int[] nums, int k) 
    {
        int tmp = 0; 
        int[] ans = new int[nums.length];
        for (int i = 0; i<nums.length; i++)
        {
            int ind = (i+k)%nums.length;
            //System.out.println(ind);
            ans[ind] = nums[i];
        }
        for (int i = 0; i<ans.length;i++)
        {
            nums[i] = ans[i];
        }
        nums = ans;
    }
}

class Solution {
    public void rotate(int[] nums, int k) 
    {
        k = k%nums.length;
        int count = 0;
        for (int start = 0; count<nums.length; start++)
        {
            int curr = start;
            int prev = nums[start];
            do
            {
                int next = (curr+k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                curr = next;
                count++;
            }
            while(start!=curr);
        }
    }
}

class Solution 
{
    public void rotate(int[] nums, int k) 
    {
      k %= nums.length;
      reverse(nums, 0, nums.length - 1);
      reverse(nums, 0, k - 1);
      reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
      while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
      }
    }
  }