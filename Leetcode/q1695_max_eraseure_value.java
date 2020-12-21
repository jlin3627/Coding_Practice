class Solution {
    public int maximumUniqueSubarray(int[] nums) 
    {
        Set<Integer> st = new HashSet<Integer>();
        Set<Integer> start = new HashSet<Integer>();
        int max = 0;
        int tmpSum = 0;
        for (int j = 0; j<nums.length; j++)
        {
            start.add(j);
            for (int i = j; i<nums.length; i++)
            {
                if (!st.contains(nums[i]))
                {
                    st.add(nums[i]);
                    tmpSum+= nums[i];
                }
                else
                {
                    st.clear();
                    if (tmpSum> max) max = tmpSum;
                    if (start.contains(i)) break;
                    else
                    {
                        start.add(i);
                    }
                    tmpSum = nums[i];
                    st.add(nums[i]);
                }
            }
            if (!st.isEmpty())
            {
                if (tmpSum>max) max = tmpSum;
            }
            tmpSum = 0;
            st.clear();
        }
        
        
        if (!st.isEmpty())
        {
            if (tmpSum>max) max = tmpSum;
        }
        
        return max;
    }
}

/*class Solution 
{
    public int maximumUniqueSubarray(int[] nums) 
    {
        int sum = 0;
        int res = 0;
        int n = nums.length;
        int j = 0;
        Set<Integer> d = new HashSet<>();
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (!d.add(nums[i])) {
                while (j < i && nums[j] != nums[i]) 
                {
                    sum -= nums[j];
                    d.remove(nums[j]);
                    j++;
                }
                j++;
                sum -= nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}*/

class Solution {
    public int maximumUniqueSubarray(int[] nums) 
    {
        int result = 0;
        int currentSum = 0;
        HashSet<Integer> set = new HashSet<>();
        int start = 0;
        for (int end = 0; end<nums.length; end++)
        {
            while (set.contains(nums[end]))
            {
                set.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }
            currentSum += nums[end];
            set.add(nums[end]);
            result = Math.max(result, currentSum);
        }
        return result;
    }
}

/*class Solution {
    public int maximumUniqueSubarray(int[] nums) 
    {
        int result = 0;
        int currentSum = 0;
        boolean[] isPresent = new boolean[10001];
        int start = 0;
        for (int end = 0; end<nums.length; end++)
        {
            while (isPresent[nums[end]])
            {
                isPresent[nums[start]] = false;
                currentSum -= nums[start];
                start++;
            }
            isPresent[nums[end]] = true;
            currentSum+=nums[end];
            result = Math.max(result, currentSum);
        }
        return result;
    }
}*/

/*class Solution {
    public int maximumUniqueSubarray(int[] nums) 
    {
        int[] countMap = new int[10001];
        int start = 0;
        int result = 0;
        int currentSum = 0;
        for (int end = 0; end<nums.length; end++)
        {
            int currentElement = nums[end];
            countMap[currentElement]++;
            currentSum += currentElement;
            while(start<end && countMap[currentElement] > 1)
            {
                countMap[nums[start]]--;
                currentSum -= nums[start];
                start++;
            }
            result = Math.max(result, currentSum);
        }
        return result;
    }
}*/


/*
class Solution {
    public int maximumUniqueSubarray(int[] nums) 
    {
        int n = nums.length;
        HashMap<Integer, Integer> lastIndexMap = new HashMap<>();
        int[] prefixSum = new int[n+1];
        int result = 0, start = 0;
        for (int end = 0; end<n; end++)
        {
            int currentElement = nums[end];
            prefixSum[end+1] = prefixSum[end] + currentElement;
            if (lastIndexMap.containsKey(currentElement))
            {
                start = Math.max(start, lastIndexMap.get(currentElement) + 1);
            }
            result = Math.max(result, prefixSum[end + 1] - prefixSum[start]);
            lastIndexMap.put(currentElement, end);
        }
        return result;
    }
}

/*
class Solution 
{
    public int maximumUniqueSubarray(int[] nums) 
    {
        int n = nums.length;
        int[] lastIndexes = new int[10001];
        int[] prefixSum = new int[n+1];
        
        Arrays.fill(lastIndexes, -1);
        int result = 0, start = 0;
        for (int end = 0; end<n; end++)
        {
            int currentElement = nums[end];
            prefixSum[end + 1] = prefixSum[end] + currentElement;
            if (lastIndexes[currentElement] != -1)
            {
                start = Math.max(start, lastIndexes[currentElement] + 1);
            }
            result = Math.max(result,prefixSum[end + 1] - prefixSum[start]);
            lastIndexes[currentElement] = end;
        }
        return result;
    }
}

*/


*/
