/*class Solution {
    public int subarraySum(int[] nums, int k) 
    {
        int tmpSum = 0;
        int count = 0;
        for (int i = 0; i<nums.length;i++)
        {
            tmpSum = 0;
            for (int j = i; j<nums.length; j++)
            {
                tmpSum += nums[j];
                if (tmpSum == k)
                {
                    count++;
                }
            }
        }
        
        return count;
        
    }
}*/

public class Solution
{
    public int subarraySum(int[] nums, int k)
    {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0,1);
        for (int i =0; i<nums.length; i++)
        {
            sum+=nums[i];
            if (mp.containsKey(sum-k))
                count += mp.get(sum-k);
            mp.put(sum, mp.getOrDefault(sum,0) + 1);
        }
        return count;
    }
}


/*
practice

public int subarraySum(int[] nums, int k)
{
    int count = 0, sum = 0;
    HashMap<Integer, Integer> mp = new HashMap<>();
    mp.put(0,1);
    for (int i = 0; i<nums.length; i++)
    {
        sum+= nums[i];
        if(mp.containsKey(sum-k))
        {
            count += mp.get(sum-k);
        }
        mp.put(sum, mp.getOrDefault(sum,0) +1);
    }
    return count;
}

public int subarraySum(int[] nums, int k)
{
    int count = 0, sum = 0;
    HashMap<Integer, Integer> mp = new HashMap<>();
    mp.put(0,1);
    for (int i = 0; i<nums.length; i++)
    {
        sum+=nums[i];
        if (mp.containsKey(sum-k))
        {
            count+= mp.get(sum-k);
        }
        mp.put(sum, mp.getOrDefault(sum,0) +1);
    }
    return count;
}

public int subarraySum(int[] nums, int k)
{
    int count = 0, sum = 0;
    HashMap<Integer, Integer> mp = new HashMap<>();
    mp.put(0,1);
    for (int i =0; i<nums.length; i++)
    {
        sum+= nums[i];
        if (mp.containsKey(sum-k))
        {
            count+=mp.get(sum-k);
        }
        mp.put(sum,mp.getOrDefault(sum,0)+1);
    }
    return count;
}

*/ 

/*class Solution 
{
    public int subarraySum(int[] nums, int k) {
        final int[] sums = new int[nums.length+1];
        for(int i=0; i<nums.length; i++) {
            sums[i+1] = sums[i] + nums[i];
        }
        return mergeSort(sums, 0, nums.length, k, new int[nums.length/2+1]);
    }
    
    //[st, ed]
    private int mergeSort(int[] sums, int st, int ed, int k, int[] paper) {
        if (st == ed) return 0;
        int mid = (st+ed)/2;
        int ans = mergeSort(sums, st, mid, k, paper) + mergeSort(sums, mid+1, ed, k, paper);
        for(int i=st, j=mid+1; i<=mid && j<=ed; i++) {
            while(j <= ed && sums[j] < k + sums[i]) j++;
            if (j<=ed && sums[j] == k+sums[i]) {
                int t=j+1;
                while(t<=ed && sums[t] == sums[j]) t++;
                ans += t-j;
            }
        }
        int len = mid-st+1;
        System.arraycopy(sums, st, paper, 0, len);
        int p = 0, i = st;
        for(int q = mid+1; p < len && q <= ed;) {
            sums[i++] = paper[p] <= sums[q] ? paper[p++] : sums[q++];
        }
        while(p<len) sums[i++] = paper[p++];
        return ans;
    }
}
*/
