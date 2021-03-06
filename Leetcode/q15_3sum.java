class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        if (nums.length<3) return new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i<nums.length && nums[i] <= 0; ++i)
        {
            if (i == 0 || nums[i-1]!=nums[i])
            {
                twoPointer(nums,i,ans);
            }
        }
        return ans;
    }
    
    void twoPointer(int[] nums, int i, List<List<Integer>> ans)
    {
        int start = i+1, end = nums.length-1;
        while(start<end)
        {
            int sum = nums[i] + nums[start] + nums[end];
            if (sum<0)
            {
                start++;
            }
            else if (sum>0)
            {
                end--;
            }
            else
            {
                List<Integer> trip = new ArrayList<Integer>();
                trip.add(nums[i]);
                trip.add(nums[start]);
                trip.add(nums[end]);
                ans.add(trip);
                start++;
                end--;
                while(start<end && nums[start] == nums[start-1])
                start++;
            }
        }
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumII(nums, i, res);
            }
        return res;
    }
    void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0) {
                ++lo;
            } else if (sum > 0) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo] == nums[lo - 1])
                    ++lo;
            }
        }
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i<nums.length && nums[i] <= 0; ++i)
        {
            if (i == 0 || nums[i-1]!=nums[i])
            {
                twoSum(nums,i,ans);
            }
        }
        return ans;
    }
    
    void twoSum(int[] nums, int i, List<List<Integer>> ans)
    {
        Set<Integer> seen = new HashSet<Integer>();
        for (int j = i+1; j<nums.length; j++)
        {
            int comp = -nums[i] - nums[j];
            if(seen.contains(comp))
            {
                ans.add(Arrays.asList(nums[i],nums[j],comp));
                while(j+1<nums.length && nums[j] == nums[j+1]) ++j;
            }
            seen.add(nums[j]);
        }
    }
}


class Solution 
{
    public List<List<Integer>> threeSum(int[] nums) 
    {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i<nums.length; ++i)
        {
            if(dups.add(nums[i]))
            {
                for (int j = i+1;j<nums.length;j++)
                {
                    int comp = -nums[i] - nums[j];
                    if(seen.containsKey(comp) && seen.get(comp) == i)
                    {
                        List<Integer> triplet = Arrays.asList(nums[i],nums[j],comp);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.put(nums[j],i);
                }
            }
        }
        return new ArrayList(res);
    }
}