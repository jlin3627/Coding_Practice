class Solution {
    public int maxSubArrayLen(int[] nums, int k) 
    {
        int n = nums.length;
        int ans = 0;
        int left = 0;
        int sum = 0;
        for (int i = 0; i<n;i++)
        {
            sum+= nums[i];
            int tmpSum = sum;
            for (int j = 0;j<=i;j++)
            {
                if (k == tmpSum) 
                {
                    ans = Math.max(ans, i+1-j);
                }
                tmpSum-=nums[j];
            }
        }
        return ans;
    }
}

class Solution 
{
    public int maxSubArrayLen(int[] nums, int k) 
    {
        int sum = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) 
        {
            sum = sum + nums[i];
            if (sum == k) max = Math.max(max,i + 1);
            else if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }
}

public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        for (int i = 1; i < n; i++)
            nums[i] += nums[i - 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // add this fake entry to make sum from 0 to j consistent
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i] - k))
                max = Math.max(max, i - map.get(nums[i] - k));
            if (!map.containsKey(nums[i])) // keep only 1st duplicate as we want first index as left as possible
                map.put(nums[i], i);
        }
        return max;
    }
}

/*class Solution 
{
    public int maxSubArrayLen(int[] nums, int k) 
    {
        int[] sum = new int[nums.length + 1];
        Map<Integer, Integer> longest = new HashMap<>(nums.length + 1);
        longest.put(0, 0); 
        for (int i = 0; i < nums.length; ++i) 
        {
            sum[i + 1] = sum[i] + nums[i];
            longest.put(sum[i + 1], i + 1);
        }
        int len = 0;
        for (int i = 0; i < nums.length; ++i) 
        {
            Integer l = longest.get(k + sum[i]);
            if (l != null && l - i > len) {
                if (l >= nums.length - 1) {
                    return l - i; 
                } 
                else {
                    len = l - i;
                }
            }
        }
        return len;
    }
    
}*/

/*class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        
        for (int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // add this fake entry to make sum from 0 to j consistent
        
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - k))
                max = Math.max(max, i - map.get(nums[i] - k));
            
            map.putIfAbsent(nums[i], i);            
        }
        return max;
    }
}*/

