import java.util.Map;

class Solution
{
    public int[] topKFrequent(int[] nums, int k)
    {
        if(k == nums.length)
        {
            return nums;
        }
        Map<Integer, Integer> mp = new HashMap();
        for (int n : nums)
        {
            mp.put(n,mp.getOrDefault(n,0) + 1);
        }

        Queue<Integer> hp = new PriorityQueue<>(
            (n1,n2) ->mp.get(n1) - mp.get(n2)
        );

        for (int n : mp.keySet())
        {
            hp.add(n);
            if(hp.size()>k) hp.poll();
        }

        int[] ans = new int[k];
        for (int i = k-1; i>=0; --i)
        {
            ans[i] = hp.poll();
        }
        return ans;
    }
}